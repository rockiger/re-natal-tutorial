(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn align-items-basics []
  ;; Try setting ':align-items' to ':flex-start'
  ;; Try setting ':justify-content' to ':flex-end'
  ;; Try setting ':flex-direction' to ':row'
  [view {:style
         {:flex 1
          :flex-direction :column
          :justify-content :center
          :align-items :center}}
   [view {:style {:width 50 :height 50 :background-color :powderblue}}]
   [view {:style {:width 50 :height 50 :background-color :skyblue}}]
   [view {:style {:width 50 :height 50 :background-color :steelblue}}]])

(defn app-root []
  [align-items-basics])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
