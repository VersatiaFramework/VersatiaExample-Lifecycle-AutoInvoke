package com.github.marcoral.versatia.example.autoinvoke

import com.github.marcoral.versatia.EventType
import com.github.marcoral.versatia.lifecycle.AutoInvoke

/** Objects carry auto-invoked functions too; no bean is needed. */
object Statistics {
    private var runs = 0

    @AutoInvoke(EventType.PLUGIN_RELOAD_OR_START)
    fun countRun(plugin: AutoInvokePlugin) {
        runs++
        plugin.logger.info("Statistics: run number $runs")
    }
}
