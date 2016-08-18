(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def list-view (r/adapt-react-class (.-ListView ReactNative)))
(def data-source (.-DataSource (.-ListView ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn- convert-to-array [vec]
  "Vector -> JavaScript Array
  consumes a Vector and produces an array, it is needed for
  the list-view, because it only accepts an real JavaScript Array."
  (let [arr #js[]] (doseq [x vec] (.push arr x)) arr))

(def ds (new data-source #js{:rowHasChanged #(not= %1 %2)}))

(def state (.cloneWithRows ds ;; we are using global state
             (convert-to-array ["John" "Joel" "James" "Jimmy" "Jackson"
                                "Jillian" "Julie" "Devin"])))

(defn list-view-basics []
  [view {:style {:padding-top 22}}
    [list-view {:dataSource state ;for whatever reason :data-source doesn't work
                ;; Turn the vector into a React element
                :render-row #(r/as-element [text %])}]])

(defn app-root []
  [list-view-basics])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial" #(r/reactify-component app-root)))
