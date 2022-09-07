(ns cljfx.fx.affine
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.transform :as fx.transform])
  (:import [javafx.scene.transform Affine]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.transform/props
    (composite/props Affine
      :mxx [:setter lifecycle/scalar :coerce double :default 1.0]
      :mxy [:setter lifecycle/scalar :coerce double :default 0.0]
      :mxz [:setter lifecycle/scalar :coerce double :default 0.0]
      :myx [:setter lifecycle/scalar :coerce double :default 0.0]
      :myy [:setter lifecycle/scalar :coerce double :default 1.0]
      :myz [:setter lifecycle/scalar :coerce double :default 0.0]
      :mzx [:setter lifecycle/scalar :coerce double :default 0.0]
      :mzy [:setter lifecycle/scalar :coerce double :default 0.0]
      :mzz [:setter lifecycle/scalar :coerce double :default 1.0]
      :tx [:setter lifecycle/scalar :coerce double :default 0.0]
      :ty [:setter lifecycle/scalar :coerce double :default 0.0]
      :tz [:setter lifecycle/scalar :coerce double :default 0.0])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Affine
      :ctor []
      :props props)
    :affine))
