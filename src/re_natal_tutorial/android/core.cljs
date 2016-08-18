(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(def state (r/atom "")) ;; we are using global state
(def favicon (js/require "./images/cljs.png"))

(defn i-scrolled-down []
  [scroll-view
    [text {:style {:font-size 96}} "Scroll me plz"]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [text {:style {:font-size 96}} "If you like"]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [text {:style {:font-size 96}} "Scrolling down"]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [text {:style {:font-size 96}} "What's the best"]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [text {:style {:font-size 96}} "Framework around"]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [image {:source favicon}]
    [text {:style {:font-size 96}} "Re-Natal"]])

(defn app-root []
  [i-scrolled-down])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial" #(r/reactify-component app-root)))
