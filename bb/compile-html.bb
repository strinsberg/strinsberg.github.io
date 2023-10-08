(require '[babashka.fs :as fs])
(require '[babashka.process :as pr])
(require '[clojure.string :as str])

;; Converts markdown files in src-dir into html and adds results to the build dir
;; Compiles all html files in src-dir by replacing placeholder with the contents
;;   of their files and writing the new file to the pages-dir.
;; Placehoders must be of the form <!--** filename.ext **-->
;; Html snippets and markdown documents cannot have placeholders. If they do
;;   those placeholders will be ignored.
;; Html file placeholders should only refer to markdown or snippets. If a
;;   placeholder refers to an html file that requires replacement the nested
;;   replacements will be ignored. We could enable this functionality by
;;   repeatedly replacing without writing to pages until there are no placeholders
;;   left, but it adds complexity that I do not need yet.

;; TODO only print on -v. (denf verbln [& args] (when verbose (apply println args)))
;; TODO try to identify common issues that will arise and either kill the
;;      script with a message or wrap things in try catch blocks to recover
;;      or abort the process.

;; Vars and helper functions

(def src-dir "src")
(def build-dir "build")
(def pages-dir "pages")
;; TODO make sure this will work if there are a different number of spaces
;; between the comment chars and the filename.
(def re-file-template #"<!--\*\* +([-_/a-zA-Z0-9]+\.[a-zA-Z]+) +\*\*-->")

(defn remove-src-dir [path]
  (str/replace (str path) (str src-dir fs/file-separator) ""))

;; TODO remove src-dir from start
(defn md-build-path-str [path]
  (str build-dir
       fs/file-separator
       (fs/strip-ext (remove-src-dir path))
       ".html"))

;; TODO remove src-dir from start
(defn pages-build-path-str [path]
  (str pages-dir
       fs/file-separator
       (remove-src-dir path)))

;; TODO check that path has extension
(defn create-parents [path]
  (->> (str path)
       fs/components
       drop-last
       (str/join fs/file-separator)
       fs/create-dirs))

;; Compile all files to markdown

(println "markdown to html:")

;; TODO filter out README.md from source folders
(run!
 ;; Compile each markdown file into the build dir as html
 (fn [path]
   (let [target-path (md-build-path-str path)]
     (println " " (str path) "->" target-path)
     (create-parents target-path)
     (pr/shell "pandoc" "-t" "html" "-o" target-path (str path))))
 ;; Find all markdown files
 (fs/glob src-dir "**.md"))

;; Load snippets

(println "loading snippets...")

(def snippets
  (reduce
   (fn [acc path]
     (assoc acc (remove-src-dir path) (slurp (str path))))
   {}
   (fs/glob src-dir (str "**snippets" fs/file-separator "*.html"))))

;; Expand html files

(println "expanding html:")

(run!
 ;; For each html file replace placeholders with file contents 
 ;; and write the new file into the pages dir
 (fn [path]
   (let [target-path (pages-build-path-str path)]
     (println " " (str path) "->" target-path)
     (create-parents target-path)
     ;; TODO error when placeholder source does not exist
     (spit target-path
           ;; TODO extract this replacement stuff into a function?
           (str/replace
            (slurp (str path))
            re-file-template
            (fn [match]
              (let [match-path (str (second match))]
                (println "    expand:" match-path)
                (if (contains? snippets match-path)
                  (get snippets match-path)
                  (slurp (md-build-path-str match-path)))))))))
 ;; Collect all html files excluding snippets
 (filter
  (fn [path] (not (contains? snippets (remove-src-dir path))))
  (fs/glob src-dir "**.html")))
