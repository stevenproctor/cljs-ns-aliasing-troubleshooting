(ns cljs-ns-aliasing.core
  (:require [core.async :as async]
            [cljs.core.async :as cljs-async]))

(defn hello-world
  "returns a channel to get a greeting to the world"
  []
  (async/go
    "Hello World"))

(defn hello-earth
  "prints out Hello to Earth x"
  [x]
  (println (str "Hello Earth-" x)))

(defn print-hello-world-async []
  (async/go
    (println (cljs-async/<! (hello-world))))
  (cljs-async/go
    (println "hello-world"))
  (cljs.core.async/go
    (loop [x (range 1 10)]
      (hello-earth x))
    (comment "and 616 because cross-overs")
    (hello-earth 616)))
