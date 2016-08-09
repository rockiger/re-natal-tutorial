(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defn hello-world []
  [text "Hello world!"])

(defn app-root []
    (hello-world))

(defn init []
      (.registerComponent app-registry "Hello World" #(r/reactify-component app-root)))
