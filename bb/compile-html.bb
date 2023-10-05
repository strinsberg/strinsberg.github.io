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

;; Vars and helper functions

(def src-dir "src")
(def build-dir "build")
(def pages-dir "pages")
(def re-file-template #"<!--\*\* ([-_/a-zA-Z0-9]+\.[a-zA-Z]+) \*\*-->")

(defn md-build-path-str [path]
  (str "build"
       fs/file-separator
       (fs/strip-ext (str path))
       ".html"))

(defn pages-build-path-str [path]
  (str "pages"
       fs/file-separator
       (str path)))

(defn create-parents [path]
  (->> (str path)
       fs/components
       drop-last
       (str/join fs/file-separator)
       fs/create-dirs))

;; Compile all files to markdown

(run!
 ;; Compile each markdown file into the build dir as html
 (fn [path]
   (create-parents path)
   (pr/shell "pandoc" "-t" "html" "-o" (md-build-path-str path) (str path)))
 ;; Find all markdown files
 (fs/glob src-dir "**.md"))

;; Load snippets

(def snippets
  (reduce
   (fn [path acc]
     (assoc acc (str path) (slurp path)))
   (fs/glob src-dir (str "**snippets" fs/file-separator "*.html"))))

;; Expand html files

(run!
 ;; For each html file replace placeholders with file contents 
 ;; and write the new file into the pages dir
 (fn [path]
   (let [target-path (pages-build-path-str path)]
     (create-parents target-path)
     (spit target-path
           (str/replace
            (slurp path)
            re-file-template
            (fn [match]
              (slurp (md-build-path-str (str (nth match 1)))))))))
;; Collect all html files excluding snippets
 (filter
  (fn [path] (not (contains? snippets path)))
  (fs/glob src-dir "**.html")))
