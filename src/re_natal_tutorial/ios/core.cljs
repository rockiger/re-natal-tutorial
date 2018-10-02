(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn justify-content-basics []
  [view {:style {:flex 1 :flex-direction :column :justify-content :space-between}}
   [view {:style {:width 50 :height 50 :background-color :powderblue}}]
   [view {:style {:width 50 :height 50 :background-color :skyblue}}]
   [view {:style {:width 50 :height 50 :background-color :steelblue}}]])

(defn app-root []
  [justify-content-basics])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
