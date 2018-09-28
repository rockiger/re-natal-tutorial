(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

;; We use function arguments instead of props because our components are functions
(defn greeting [name]
  [text (str "Hello " name "!")])

(defn app-root []
  [view {:style {:align-items "center"}}
   (greeting "Rexxar")
   (greeting "Jaina")
   (greeting "Valeera")])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
