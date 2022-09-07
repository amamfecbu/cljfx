(ns cljfx.fx.accordion
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.control :as fx.control]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.control Accordion]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.control/props
    (composite/props Accordion
      ;; overrides
      :style-class [:list lifecycle/scalar :coerce coerce/style-class :default "accordion"]
      ;; definitions
      :panes [:list lifecycle/dynamics])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Accordion
      :ctor []
      :props props)
    :accordion))
