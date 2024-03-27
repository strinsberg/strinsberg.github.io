(ns utility
  (:require [babashka.fs :as fs]
            [hiccup2.core :as h]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(defn fix-404 [path] (str/replace path "_404" "404"))

(defn html-file
  "Convert the filename and path to a file object. If the path is nil or an empty string 'cwd/pages' will be joined to the filename. If the filename does not end in .html it will be appended."
  [filename path]
  (let [name (fix-404 (if (str/ends-with? filename ".html")
                        filename
                        (str filename ".html")))]
    (if (and path (not (str/blank? path)))
      (fs/file path (str name))
      (fs/file (fs/cwd) "pages" name))))

(defn write-hiccup
  [file hiccup]
  (spit file (str "<!DOCTYPE html>" (h/html hiccup))))

(defn compile-html
  [namespace]
  (write-hiccup (html-file namespace nil)
                ;; This only works when namespace/page is a function that returns the hiccup
                ((requiring-resolve (symbol (str namespace "/page"))))))

(defn text->id
  "Text to an acceptable HTML id string. 'Some Text Heading' -> 'some-text-heading'."
  [text]
  (->> (str/split text #"\s")
       (map str/lower-case)
       (str/join "-")))

;; This is probably not necessary anymore, but I will leave it just in case.
(defn get-cljs
  "Open a cljs file from the js dir and return its contents as a string after removing all forms before the first def or defn."
  [path]
  (let [cljs (edn/read-string
              (str "(" (slurp (fs/file (fs/cwd) "js" "cljs" path)) ")"))]
    (apply str
           (drop-while
            (fn [node] (not (or (= (first node) 'def) (= (first node) 'defn))))
            cljs))))

(defn filter-headings
  "From a hiccup element return a list of heading info maps from top-level headings."
  [hiccup-body max-depth]
  (->> (if (map? (second hiccup-body)) (drop 2 hiccup-body) (rest hiccup-body))
       (filter (fn [x]
                 (and (vector? x) (re-matches #":h[1-9]" (str (first x))))))
       (map (fn [x]
              {:rank (parse-long (str (nth (str (first x)) 2)))
               :title (apply str (nth x 2))
               :id (:id (second x))}))
       (filter (fn [x] (<= (:rank x) max-depth)))))

(defn contents-tree
  "Return a list of heading info maps with subheadings nested inside the :children key."
  [xs]
  (cond (empty? xs) (list)
        (empty? (rest xs)) (list (first xs))
        :else (let [head (first xs)
                    children (contents-tree
                              (take-while (fn [x] (> (:rank x) (:rank head)))
                                          (rest xs)))
                    next (contents-tree (drop-while
                                         (fn [x] (> (:rank x) (:rank head)))
                                         (rest xs)))]
                (cons (assoc head :children children) next))))
