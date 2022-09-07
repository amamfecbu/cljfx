(ns cljfx.fx.mesh-view
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.shape3d :as fx.shape3d])
  (:import [javafx.scene.shape MeshView]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.shape3d/props
    (composite/props MeshView
      :mesh [:setter lifecycle/dynamic])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe MeshView
      :ctor []
      :props props)
    :mesh-view))
