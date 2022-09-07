(ns cljfx.fx.label
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.fx.labeled :as fx.labeled]
            [cljfx.coerce :as coerce]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.control Label]
           [javafx.scene AccessibleRole]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.labeled/props
    (composite/props Label
      ;; overrides
      :style-class [:list lifecycle/scalar :coerce coerce/style-class :default "label"]
      :accessible-role [:setter lifecycle/scalar :coerce (coerce/enum AccessibleRole)
                        :default :text]
      ;; definitions
      :label-for [:setter lifecycle/dynamic])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Label
      :ctor []
      :props props)
    :label))
