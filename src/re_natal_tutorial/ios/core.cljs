(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def image (r/adapt-react-class (.-Image ReactNative)))

(defn bananas []
  [image {:source {:uri "https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg"}
          :style {:width 193 :height 110}}])

(defn app-root []
  [bananas])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
