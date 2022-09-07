(ns cljfx.fx.slider
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.control :as fx.control])
  (:import [javafx.scene.control Slider]
           [javafx.geometry Orientation]
           [javafx.scene AccessibleRole]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.control/props
    (composite/props Slider
      ;; overrides
      :style-class [:list lifecycle/scalar :coerce coerce/style-class :default "slider"]
      :accessible-role [:setter lifecycle/scalar :coerce (coerce/enum AccessibleRole)
                        :default :slider]
      ;; definitions
      :block-increment [:setter lifecycle/scalar :coerce double :default 10.0]
      :label-formatter [:setter lifecycle/scalar :coerce coerce/string-converter]
      :major-tick-unit [:setter lifecycle/scalar :coerce double :default 25.0]
      :max [:setter lifecycle/scalar :coerce double :default 100.0]
      :min [:setter lifecycle/scalar :coerce double :default 0.0]
      :minor-tick-count [:setter lifecycle/scalar :coerce int :default 3]
      :orientation [:setter lifecycle/scalar :coerce (coerce/enum Orientation)
                    :default :horizontal]
      :show-tick-labels [:setter lifecycle/scalar :default false]
      :show-tick-marks [:setter lifecycle/scalar :default false]
      :snap-to-ticks [:setter lifecycle/scalar :default false]
      :value [:setter lifecycle/scalar :coerce double :default 0.0]
      :on-value-changed [:property-change-listener lifecycle/change-listener]
      :value-changing [:setter lifecycle/scalar :default false])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Slider
      :ctor []
      :props props)
    :slider))
