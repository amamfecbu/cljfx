(ns cljfx.fx.motion-blur
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.effect MotionBlur]))

(set! *warn-on-reflection* true)

(def props
  (composite/props MotionBlur
    :input [:setter lifecycle/dynamic]
    :radius [:setter lifecycle/scalar :coerce double :default 10]
    :angle [:setter lifecycle/scalar :coerce double :default 0]))

(def lifecycle
  (lifecycle/annotate
    (composite/describe MotionBlur
      :ctor []
      :props props)
    :motion-blur))
