;; Check if local storage is available ;;

(defn local-storage?
  []
  (let [test "test"]
    (try (.setItem js/localStorage test test)
         (.removeItem js/localStorage test)
         true
         (catch js/Error _ false))))


;; Page Theme Toggling ;;

(defn toggle-dark-mode
  []
  (when (local-storage?)
    (let [dark (.getItem js/localStorage "dark")]
      (if (or (nil? dark) (identical? dark "off"))
        (do (.setItem js/localStorage "dark" "on")
            (.add js/document.body.classList "latex-dark"))
        (do (.setItem js/localStorage "dark" "off")
            (.remove js/document.body.classList "latex-dark"))))))

(defn set-mode
  []
  (when (local-storage?)
    (let [dark (.getItem js/localStorage "dark")]
      (when (and (not (nil? dark)) (identical? dark "on"))
        (.add js/document.body.classList "latex-dark")))))


;; Export functions to use from JavaScript ;;

(set! (.-toggle_dark_mode js/window) toggle-dark-mode)
(set! (.-set_mode js/window) set-mode)
