(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]
            [re-natal-tutorial.my-scene :as ms]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def navigator (r/adapt-react-class (.-Navigator ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defn yo-dawg-app []
  [navigator {:initial-route {:title "Awesome Scene" :index 0}
              :render-scene (fn [route, navigator]
                              (r/as-element
                                (ms/my-scene (.-title route))))}])

(defn app-root []
  [yo-dawg-app])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial"
       #(r/reactify-component app-root)))
