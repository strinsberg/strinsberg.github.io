(require '[babashka.fs :as fs])
(require '[babashka.process :as pr])
(require '[clojure.string :as str])

;; create the build directory for markdown caching
;; compile all the markdown files to html and place in build folder with an
;;   identical path (but html)
;; slurp all snippets into a map keyed with their path string
;; expand all html templates and place them in the identical path in pages

;; When expanding look for markdown files in the build folder with .html
;;  instead of md
;; When expanding snippets use the snippet map and the file string provided
;; This should make expansion very simple, as there are no nested expansions

(def src-dir "src")

(defn md-build-path-str [path-str]
  (str "build"
       fs/file-separator
       (fs/strip-ext path-str)
       ".html"))


;; Compile all files to markdown

(run!
  ;; Function for compiling each markdown file
  (fn [path]

    ;; Get path as a string
    (let [path-str (str path)]

      ;; Create directories for the path if necessary
      (->> path-str
           fs/components
           drop-last
           (str/join fs/file-separator)
           fs/create-dirs)

      ;; Compile the file to html with pandoc
      (pr/shell "pandoc" "-t" "html" "-o" (md-build-path path-str) path-str)))

  ;; Find all markdown files
  (glob src-dir "**.md"))

 
;; Load snippets

(def snippets
  (reduce
    (fn [path acc]
      (assco acc (str path) (slurp path)))
    (fs/glob src-dir (str "**snippets" fs/file-separator "*.html"))))


;; Expand html files

;; find all html files
;; for each one slurp contents
;;   get all replacement file names
;;   for each replacement either slurp the html build file or the snippets text
;;     and replace the text in the file
;;   spit the result to the same path, but in pages

(def re-file-template #"<!--\*\* ([-_/a-zA-Z0-9]+\.[a-zA-Z]+) \*\*-->")
; (str/replace code
;              re-file-template
;              (fn [match]
;                (slurp (md-build-path-str (str (nth match 1))))))
