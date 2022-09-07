(ns cljfx.fx.button
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.fx.button-base :as fx.button-base]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.control Button]
           [javafx.scene AccessibleRole]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.button-base/props
    (composite/props Button
      ;; overrides
      :style-class [:list lifecycle/scalar
                    :coerce coerce/style-class
                    :default "button"]
      :accessible-role [:setter lifecycle/scalar
                        :coerce (coerce/enum AccessibleRole)
                        :default :button]
      :mnemonic-parsing [:setter lifecycle/scalar :default true]
      ;; definitions
      :cancel-button [:setter lifecycle/scalar :default false]
      :default-button [:setter lifecycle/scalar :default false])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe Button
      :ctor []
      :props props)
    :button))
