(ns utility
  (:require [babashka.fs :as fs]
            [hiccup2.core :as h]
            [clojure.edn :as edn]
            [clojure.string :as str]))


(defn html-file
  "Convert the filename and path to a file object. If the path is nil or an empty string 'cwd/pages' will be joined to the filename. If the filename does not end in .html it will be appended."
  [filename path]
  (let [name
        (if (str/ends-with? filename ".html") filename (str filename ".html"))]
    (if (and path (not (str/blank? path)))
      (fs/file path (str name))
      (fs/file (fs/cwd) "pages" name))))

(defn write-hiccup
  [file hiccup]
  (spit file (str "<!DOCTYPE html>" (h/html hiccup))))

(defn text->id
  "Text to an acceptable HTML id string. 'Some Text Heading' -> 'some-text-heading'."
  [text]
  (->> (str/split text #"\s")
       (map str/lower-case)
       (str/join "-")))

(defn get-cljs
  "Open a cljs file from the js dir and return its contents as a string after removing all forms before the first def or defn."
  [path]
  (let [cljs (edn/read-string
              (str "(" (slurp (fs/file (fs/cwd) "js" path)) ")"))]
    (apply str
           (drop-while
            (fn [node] (not (or (= (first node) 'def) (= (first node) 'defn))))
            cljs))))
