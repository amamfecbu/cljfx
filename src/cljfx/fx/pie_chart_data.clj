(ns cljfx.fx.pie-chart-data
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.chart PieChart$Data]))

(set! *warn-on-reflection* true)

(def props
  (composite/props PieChart$Data
    :name [:setter lifecycle/scalar]
    :pie-value [:setter lifecycle/scalar :coerce double :default 0]))

(def lifecycle
  (lifecycle/annotate
    (composite/describe PieChart$Data
      :ctor [:name :pie-value]
      :props props)
    :pie-chart-data))
