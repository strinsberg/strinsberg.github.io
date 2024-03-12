(ns snippets
  (:require [hiccup2.core :as h]
            [utility :as util]
            [clojure.string :as str]))


;; Page Building ;;

(defn head
  [title]
  [:head [:title title]
   ;; Meta Data
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:link {:rel "stylesheet" :href "https://latex.now.sh/style.css"}]
   [:link {:rel "stylesheet" :href "/css/style.css"}]
   ;; Scittle interpreter CDN
   [:script
    {:src "https://cdn.jsdelivr.net/npm/scittle@0.6.15/dist/scittle.js"
     :type "application/javascript"}]
   ;; The general cljs page functions, like darkmode switching
   [:script {:type "application/x-scittle"}
    (h/raw (util/get-cljs "page-functions.cljs"))]])

(def footer
  [:div [:br] [:hr] "© Steven Deutekom 2023" [:br] "Styled with "
   [:a {:href "https://latex.now.sh"} "latex.css"]])

(def dark-mode-button
  [:button
   {:style
    "position: absolute; top: 10px; right: 10px; cursor: pointer; border: 0px solid rgb(0,0,0,0); background-color: transparent;"
    :onclick "toggle_dark_mode()"
    :title "Toggle between light and dark page themes"} "🌗"])

(def main-nav-list
  [["Home" "/"] ["Portfolio" "/portfolio"]
   ["Github" "https://github.com/strinsberg"]])

(defn nav
  [elements]
  [:nav {:class "nav-list"}
   (->> elements
        (map (fn [elem]
               (if (string? elem)
                 [:em elem]
                 [:a {:href (second elem) :target "_blank"} (first elem)])))
        (interpose " | "))])

(defn main-nav
  [page]
  (nav (filter (fn [x] (not= (str/lower-case (first x)) (str/lower-case page)))
               main-nav-list)))

(defn abstract
  [args]
  [:div {:class "abstract"}
   [:summary (interpose [:br] (map (fn [text] [:p text]) args))]])

(defn page
  [title intro & body]
  [:html (head title)
   [:body {:class "libertinus" :onload "set_mode()"}
    [:h1 {:style "text-align: center;"} title dark-mode-button]
    (main-nav title) (abstract intro) [:hr] body footer]])

;; Html Helpers ;;

(defn h
  "Create an html heading in hiccup. [:h<rank> text]"
  [rank text]
  [(keyword (str "h" rank)) {:id (util/text->id text)} text])
