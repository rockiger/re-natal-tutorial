(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def flat-list (r/adapt-react-class (.-FlatList ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(def styles {:container {:flex 1
                         :padding-top 22}
             :item {:padding 10
                    :fontSize 18
                    :height 44}})

(defn flat-list-basics []
  [view {:style (:container styles)}
   [flat-list {:data #js["Devin" "Jackson" "James" "Joel" "John" "Jillian" "Jimmy" "Julie"]
               :keyExtractor #(js* "Math.random().toString(32).slice(2)")
               :render-item #(r/as-element [text {:style (:item styles)}
                                            (get-in (js->clj % :keywordize-keys true) [:item])])}]])

(defn app-root []
  [flat-list-basics])

(defn init []
  (.registerComponent app-registry "ReNatalTutorial" #(r/reactify-component app-root)))
