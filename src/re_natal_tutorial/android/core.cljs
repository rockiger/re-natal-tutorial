(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def image (r/adapt-react-class (.-Image ReactNative)))

(defn app-root []
  [image {:source {:uri "https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg"}
          :style {:width 193 :height 110}}])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
