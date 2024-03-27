(ns _404
  (:require [snippets :as snip]))

(defn page
  []
  (snip/page "404"
             "404 Page Not Found"
             ["Looks like this page does not exist!"]))
