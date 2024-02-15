(ns compile-html
  (:require [babashka.fs :as fs]
            [babashka.process :as pr]
            [babashka.cli :as cli]
            [clojure.string :as str]))

;; Converts markdown files in src-dir into html and adds results to the build dir.
;; Expands all compiled markdown files and writes them back to the build dir.
;;   This has to be done before expanding html files in src-dir because these
;;   files are not written directly to pages. TODO either make the expansion
;;   recursive, which needs to keep track of which files have already been
;;   expanded, or check expansison of md files explicitly to ensure they are
;;   only expanding with snippets.
;; Expands all html files in src-dir by replacing placeholders with the contents
;;   of their files and writing the new file to the pages-dir.

;; Placehoders must be of the form <!--** filename.ext **-->
;; Markdown files should only have snippet placeholders. Those snippets can be
;;   either html or md. They should not be md files that are not considered
;;   snippets. I.e. no snippets, md or html, should include placeholders. They
;;   will either be ignored or not resolve in the right order if a placeholder
;;   file also includes placeholders.
;; Html snippets cannot have placeholders. If they do those placeholders will be ignored.
;; Html file placeholders should only refer to markdown or snippets for the
;;   same reason as markdown files referencing other markdown files.

;; TODO try to identify common issues that will arise and either kill the
;;      script with a message or wrap things in try catch blocks to recover
;;      or abort the process.
;; TODO while verbose output can be used to see that a snippet file path was
;;      not found and no substitution took place, we should error when finding
;;      a placeholder with a non-existent file.

;; Vars ;;;;;;;;;;;;;;;

(def verbose (atom false))
(def src-dir "src")
(def build-dir "build")
(def pages-dir "pages")
(def re-file-template #"<!--\*\* *([-_/a-zA-Z0-9]+\.[a-zA-Z]+) *\*\*-->")

;; Helpers ;;;;;;;;;;;;;

;; Remove a dir from a path
;; E.g. remove src dir/src/file.md -> dir/file.md
(defn remove-dir
  [path dir]
  (str/replace (str path) (str dir fs/file-separator) ""))

;; Create a path for a compiled markdown file from
;; src/path/to/file -> build/path/to/file
(defn md-build-path-str
  [path]
  (str build-dir
       fs/file-separator
       (fs/strip-ext (remove-dir path src-dir))
       ".html"))

;; Create a path for an expanded html file from
;; src/path/to/file or build/path/to/file -> pages/path/to/file
(defn pages-path-str
  [path]
  (let [trimmed (-> path
                    (remove-dir src-dir)
                    (remove-dir build-dir))]
    (str pages-dir fs/file-separator trimmed)))

;; Create a path for an expanded html file from
;; src/path/to/file -> dest/path/to/file
(defn dest-path-str
  [path dest src]
  (str dest fs/file-separator (remove-dir path src)))

;; TODO check that path has extension
;; Create the parent directories for a pile path if they do not exist.
;; E.g. path/to/file will create path/ and path/to/
(defn create-parents
  [path]
  (->> (str path)
       fs/components
       drop-last
       (str/join fs/file-separator)
       fs/create-dirs))

;; Print information only when verbose is true
(defn -print [& args] (when @verbose (apply println args)))

;; Compilation Functions ;;;;;;;;;;;;;;;;;;

;; Load all snippets into a map of paths to contents
(defn load-snippets
  []
  (-print "loading snippets...")
  (reduce (fn [acc path]
            (assoc acc (remove-dir path src-dir) (slurp (str path))))
          {}
          (fs/glob src-dir (str "**snippets" fs/file-separator "*.html"))))

;; Compile all markdown files to html
(defn compile-md
  []
  (run!
   ;; Compile each markdown file into the build dir as html
   (fn [path]
     (let [target-path (md-build-path-str path)]
       (-print " " (str path) "->" target-path)
       (create-parents target-path)
       (pr/shell "pandoc" "-t" "html" "-o" target-path (str path))))
   ;; Find all markdown files
   (fs/glob src-dir "**.md")))

;; Expands an html file replacing placeholders with source code and returns
;; the result as a string.
(defn expand-html
  [path snippets]
  (str/replace (slurp (str path))
               re-file-template
               (fn [match]
                 (let [match-path (str (second match))]
                   (-print "    expand:" match-path)
                   (if (contains? snippets match-path)
                     (get snippets match-path)
                     (slurp (md-build-path-str match-path)))))))

;; Expands all html files in the src dir and writes them to a path in the dest dir.
(defn expand-all
  [src dest snippets]
  (run!
   ;; For each html file replace placeholders with file contents
   ;; and write the new file into the pages dir
   (fn [path]
     (let [target-path (dest-path-str path dest src)]
       (-print " " (str path) "->" target-path)
       (create-parents target-path)
       ;; TODO error when placeholder source does not exist
       (spit target-path (expand-html path snippets))))
   ;; Find all html files in src dir.
   (filter (fn [path] (not (contains? snippets (remove-dir path src))))
           (fs/glob src "**.html"))))

;; Main ;;;;;;;;;;;;;;;;;;

;; Main function to run the script
(defn -main
  [& cli-args]
  (let [args (cli/parse-opts cli-args {:spec {:verbose {:coerce :boolean}}})]
    (when (:verbose args) (swap! verbose not))
    (let [snippets (load-snippets)]
      (-print "markdown to html:")
      (compile-md)
      (-print "expanding compiled markdown:")
      (expand-all build-dir build-dir snippets)
      (-print "expanding html:")
      (expand-all src-dir pages-dir snippets))))
