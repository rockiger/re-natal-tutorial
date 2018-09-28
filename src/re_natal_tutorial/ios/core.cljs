(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn blink [txt]
  (let [show-text? (r/atom true)]
    (fn [txt]
      (js/setTimeout #(swap! show-text? not) 1000)
      [text (if @show-text?
              txt
              "")])))

(defn app-root []
  [view
   [blink "I love to blink"]
   [blink "Yes blinking is so great"]
   [blink "Why did they ever take this out of HTML"]
   [blink "Look at me look at me look at me"]])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
