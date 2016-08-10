(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))

(defn hello-world-app []
  [text "Hello world!"])


(defn bananas []
  (let [img (js/require "./images/Bananavarieties.jpg")]
  ;; download the file into "images" directory
  ;; When you have dropped a new image to "images" dir,
  ;; you need to restart RN packager and re-run command:
  ;; $ re-natal use-figwheel
    [image {:source img}]))
  ;; I don't know why, but the following code from the tutorial does not work.
  ;; Seems to have something to do with figwheel.
  ;; [image {:source
  ;;           {:uri
  ;;            "https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg"}}])

(defn app-root []
  (bananas))

(defn init []
      (.registerComponent app-registry "Hello World" #(r/reactify-component app-root)))
