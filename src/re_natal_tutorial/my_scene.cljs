(ns re-natal-tutorial.my-scene
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn my-scene []
  (let [title "MyScene"]
   (fn []
    [view
      [text (str "Hi! My name is " title)]])))
