(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(def styles {:bigblue {:color :blue
                       :fontWeight :bold ; clojure style :font-weight did not work
                       :fontSize 30}     ; clojure style :font-size did not work
             :red {:color :red}})

(defn lots-of-styles []
  [view
    [text {:style (:red styles)} "just red"]
    [text {:style (:bigblue styles)} "just bigblue"]
    [text {:style [(:bigblue styles) (:red styles)]} "bigblue, then red"]
    [text {:style [(:red styles) (:bigblue styles)]} "red, then bigblue"]])

(defn app-root []
  [lots-of-styles])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
