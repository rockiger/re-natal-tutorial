(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn greeting [name]
  [text (str "Hello " name "!")])

(defn lots-of-greetings []
  [view {:style {:align-items "center"}}
    (greeting "Rexxar")
    (greeting "Jaina")
    (greeting "Valeera")])

(defn app-root []
  (lots-of-greetings))

(defn init []
      (.registerComponent app-registry "Hello World" #(r/reactify-component app-root)))
