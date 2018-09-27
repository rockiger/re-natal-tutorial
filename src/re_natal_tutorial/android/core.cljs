(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def image (r/adapt-react-class (.-Image ReactNative)))

(def state (r/atom ""))

;; Get the json
(def request (new js/XMLHttpRequest))
(set! (.-onreadystatechange request)
      (fn [e]
        (cond (not= (.-readyState request) 4)
              nil
              (= (.-status request) 200)
              (reset! state (.-responseText request))
              :else
              (.warn js/console "error"))))

(.open request "GET" "http://facebook.github.io/react-native/movies.json")                         (.send request)


(defn fetch-some-movies []
  [view {:style {:padding-top 22}}
    [text @state]])

(defn app-root []
  [image {:source {:uri "https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg"}
          :style {:width 193 :height 110}}])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
