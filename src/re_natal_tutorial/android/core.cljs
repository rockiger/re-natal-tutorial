(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn lots-of-styles []
  [view
    [view {:style {:width 50 :height 50 :background-color :powderblue}}]
    [view {:style {:width 100 :height 100 :background-color :skyblue}}]
    [view {:style {:width 150 :height 150 :background-color :steelblue}}]])

(defn app-root []
  [lots-of-styles])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial" #(r/reactify-component app-root)))
