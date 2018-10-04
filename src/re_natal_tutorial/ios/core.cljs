(ns re-natal-tutorial.ios.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn i-scrolled-down []
  [scroll-view
   [text {:style {:font-size 96}} "Scroll me plz"]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [text {:style {:font-size 96}} "If you like"]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [text {:style {:font-size 96}} "Scrolling down"]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [text {:style {:font-size 96}} "What's the best"]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [text {:style {:font-size 96}} "Framework around"]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [image {:source {:uri "https://facebook.github.io/react-native/img/favicon.png"} :style {:width 64 :height 64}}]
   [text {:style {:font-size 96}} "Re-Natal"]])

(defn app-root []
  [i-scrolled-down])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
