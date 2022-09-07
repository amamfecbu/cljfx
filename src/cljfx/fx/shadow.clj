(ns cljfx.fx.shadow
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.effect Shadow BlurType]))

(set! *warn-on-reflection* true)

(def props
  (composite/props Shadow
    :input [:setter lifecycle/dynamic]
    :radius [:setter lifecycle/scalar :coerce double :default 10.0]
    :width [:setter lifecycle/scalar :coerce double :default 21.0]
    :height [:setter lifecycle/scalar :coerce double :default 21.0]
    :blur-type [:setter lifecycle/scalar :coerce (coerce/enum BlurType)
                :default :three-pass-box]
    :color [:setter lifecycle/scalar :coerce coerce/color :default :black]))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Shadow
      :ctor []
      :props props)
    :shadow))
