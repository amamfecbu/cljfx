(ns cljfx.fx.perspective-camera
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.camera :as fx.camera])
  (:import [javafx.scene PerspectiveCamera]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.camera/props
    (composite/props PerspectiveCamera
      :field-of-view [:setter lifecycle/scalar :coerce double :default 30.0]
      :vertical-field-of-view [:setter lifecycle/scalar :default true])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe PerspectiveCamera
      :ctor []
      :props props)
    :perspective-camera))
