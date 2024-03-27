(ns snippets
  (:require [hiccup2.core :as h]
            [utility :as util]
            [clojure.string :as str]))


;; Page Building ;;

(def max-contents-depth 2)

(defn head
  [title]
  [:head [:title title]
   ;; Meta Data
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:link {:rel "stylesheet" :type "text/css" :href "/css/style.css"}]
   [:link {:rel "stylesheet" :href "https://latex.now.sh/style.css"}]
   [:link {:rel "icon" :type "image/x-icon" :href "/assets/favicon.ico"}]
   ;; Scittle interpreter CDN
   [:script
    {:src "https://cdn.jsdelivr.net/npm/scittle@0.6.15/dist/scittle.js"
     :type "application/javascript"}]
   ;; The general cljs page functions, like darkmode switching
   [:script
    {:src "/js/cljs/page-functions.cljs" :type "application/x-scittle"}]])

(def footer
  [:div [:br] [:hr] "© Steven Deutekom 2023" [:br] "Styled with "
   [:a {:href "https://latex.now.sh"} "latex.css"]])

(def dark-mode-button
  [:button
   {:class "dark-mode-button"
    :onclick "toggle_dark_mode()"
    :title "Toggle between light and dark page themes"} "🌗"])

(def main-nav-list
  [["Home" "/index.html"] ["Portfolio" "/portfolio.html"]
   ["Github" "https://github.com/strinsberg"]])

(defn link
  [[text href]]
  (let [opt {:href href}]
    [:a (if (str/starts-with? href "/") opt (assoc opt :target "_blank"))
     text]))

(defn nav
  [elements]
  [:nav {:class "nav-list"}
   (->> elements
        (map (fn [elem] (if (string? elem) [:em elem] (link elem))))
        (interpose " | "))])

(defn nav-br [elements] (list [:br] (nav elements)))

(defn main-nav
  [page-id]
  (nav (filter (fn [x]
                 (not= (str/lower-case (first x)) (str/lower-case page-id)))
               main-nav-list)))

(defn abstract
  [args]
  [:div {:class "abstract"}
   [:summary (interpose [:br] (map (fn [text] [:p text]) args))]])

(defn build-contents
  [headings]
  [:ul
   (map (fn [x] [:li [:a {:href (str "#" (:id x))} (:title x)]
                 (build-contents (:children x))])
        headings)])

(defn contents
  [body]
  (let [con (-> body
                (util/filter-headings max-contents-depth)
                util/contents-tree)]
    (when (seq con)
      [:div [:hr] [:h1 "Contents"] (build-contents con) [:br] [:hr]])))

(defn page
  [id title intro & body]
  [:html (head title)
   [:body {:class "libertinus" :onload "set_mode()"}
    [:h1 {:id "title" :style "text-align: center;"} title dark-mode-button]
    (main-nav id) (abstract intro) (contents (cons :body body)) body footer]])


;; Html Helpers ;;

(defn h
  "Create an html heading in hiccup with a link to top of page if heading rank
   is below max-contents-depth."
  [rank text]
  [(keyword (str "h" rank)) {:id (util/text->id text)} text
   (when (<= rank max-contents-depth)
     (list " " [:a {:href "#title" :style "font-size: 16px;"} "⇈"]))])

(defn img-set
  "Make a horizontal list of 2 images that will change to verticle on smaller screens.
   The images will link to larger versions in a new tab, if perhaps a person wants to
   see the image better."
  [& img-data]
  [:div {:style "margin-top: 1em; overflow: auto;"}
   (map (fn [[path alt]] [:div {:class "proj-img"}
                          [:a {:href path :target "_blank"}
                           [:img {:alt alt :src path}]]])
        img-data)])

(defn skills
  "Make a list of skills."
  [& skills]
  [:p {:style "color: #555555;"} [:em skills]])

(defn skills-key
  "Make a list of skills from keywords."
  [& skills]
  [:p {:style "color: #555555;"}
   [:em
    (interpose ", "
     (map (fn [s]
            (-> s
                str
                (str/replace ":" "")
                (str/replace "-" " ")))
          skills))]])

(defn subsec
  []
  (list [:br]
        [:hr
         {:style "height: 1px; border: none; background-color: #555555;"}]))
