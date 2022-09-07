(ns cljfx.fx.move-to
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.path-element :as fx.path-element])
  (:import [javafx.scene.shape MoveTo]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.path-element/props
    (composite/props MoveTo
      :x [:setter lifecycle/scalar :coerce double :default 0]
      :y [:setter lifecycle/scalar :coerce double :default 0])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe MoveTo
      :ctor []
      :props props)
    :move-to))
