(ns re-natal-tutorial.my-scene
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def touchable (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def navigator (r/adapt-react-class (.-Navigator ReactNative)))

(defn my-scene
  [title navi on-forward on-back]
  [view
    [text (str "Current Scene: " @title)]
    [touchable {:on-press #(on-forward navi)}
      [text "Tap me to load the next scene"]]
    [touchable {:on-press #(on-back navi)}
      [text "Tap me to go back"]]])
