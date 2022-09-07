(ns cljfx.fx.context-menu
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.popup-control :as fx.popup-control]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.control ContextMenu]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.popup-control/props
    (composite/props ContextMenu
      ;; overrides
      :style-class [:list lifecycle/scalar :coerce coerce/style-class
                    :default "context-menu"]
      :auto-hide [:setter lifecycle/scalar :default true]
      :consume-auto-hiding-events [:setter lifecycle/scalar :default false]
      ;; definitions
      :items [:list lifecycle/dynamics]
      :on-action [:setter lifecycle/event-handler :coerce coerce/event-handler])))

(def lifecycle
  (lifecycle/annotate
    (composite/describe ContextMenu
      :ctor []
      :props props)
    :context-menu))
