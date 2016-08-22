(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]
            [re-natal-tutorial.my-scene :as ms]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def navigator (r/adapt-react-class (.-Navigator ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(def index (r/atom 0))
(def title (r/atom "Awesome Scene"))


(defn simple-navigation-app []
  (let
    [on-forward (fn [navi]
                  (do
                    (swap! index inc)
                    (reset! title (str "Scene " @index))
                    (.push navi {:title (str "Scene " @index)
                                 :index @index})))
     on-back (fn [navi]
               (when (pos? @index)
                 (swap! index dec)
                 (reset! title (str "Scene " @index))
                 (.pop navi)))]
    [navigator {:initial-route {:title "Awesome Scene" :index 0}
                :render-scene (fn [route, navi]
                                (r/as-element
                                  (ms/my-scene title navi
                                    on-forward on-back)))}]))

(defn app-root []
  [simple-navigation-app])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial"
       #(r/reactify-component app-root)))
