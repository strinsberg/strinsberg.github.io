(ns index
  (:require [snippets :as snip]))

(defn page
  []
  (snip/page
   "home"
   "Steven's Homepage"

   ;; Intro ;;
   [[:div "Welcome to my homepage. This page is still under construction. The "
     [:a {:href "portfolio.html"} "Portfolio"]
     " page is finished and contains information on my work experience and personal projects."]]

   [:img
    {:src "/assets/duck-512.webp"
     :alt "A poorly drawn cartoon duck."
     :style "margin: auto;"}]


   ;
  ))
