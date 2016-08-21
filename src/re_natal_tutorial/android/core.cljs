(ns re-natal-tutorial.android.core
  (:require [reagent.core :as r]
            [re-natal-tutorial.my-scene :as ms]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(defn yo-dawg-app []
  [ms/my-scene])

(defn app-root []
  [yo-dawg-app])

(defn init []
      (.registerComponent app-registry "Re-Natal Tutorial"
       #(r/reactify-component app-root)))
