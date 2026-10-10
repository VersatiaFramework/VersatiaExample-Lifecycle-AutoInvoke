package com.github.marcoral.versatia.example.autoinvoke

import com.github.marcoral.versatia.EventType
import com.github.marcoral.versatia.lifecycle.AutoInvoke

/** Objects carry auto-invoked functions too; no bean is needed. */
object Statistics {
    private var starts = 0

    @AutoInvoke(EventType.PLUGIN_RELOAD_OR_START)
    fun countStart() {
        starts++
        log("start number $starts")
    }
}
