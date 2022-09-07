(ns cljfx.fx.html-editor
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.fx.control :as fx.control]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.web HTMLEditor]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.control/props
    (composite/props HTMLEditor
      :html-text [:setter lifecycle/scalar :default
                  "<html><head></head><body contenteditable=\"true\"></body></html>"])))


(def lifecycle
  (lifecycle/annotate
    (composite/describe HTMLEditor
      :ctor []
      :props props)
    :html-editor))
