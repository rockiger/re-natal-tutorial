(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def text-input (r/adapt-react-class (.-TextInput ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(def state (r/atom "")) ;; we are using global state

(defn pizza-translater []
  [view {:style {:padding 10}}
   [text-input {:style {:height 40}
                :placeholder "Type here to translate!"
                :on-change-text #(reset! state %)}]
   [text {:style {:padding 10 :font-size 42}}
    ;; clojure.string does not work in
    (.join (.map (.split @state " ") #(when (not-empty %) "🍕")) " ")]])

(defn app-root []
  [pizza-translater])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
