(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn app-root []
  [view {:style {:flex 1}}
   [view {:style {:flex 1 :background-color :powderblue}}]
   [view {:style {:flex 2 :background-color :skyblue}}]
   [view {:style {:flex 3 :background-color :steelblue}}]])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
