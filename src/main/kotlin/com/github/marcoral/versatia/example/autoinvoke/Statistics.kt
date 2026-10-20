package com.github.marcoral.versatia.example.autoinvoke

import com.github.marcoral.versatia.Phase
import com.github.marcoral.versatia.lifecycle.AutoInvoke
import java.util.logging.Logger

/** Objects carry auto-invoked functions too; no bean is needed. */
object Statistics {
    private var runs = 0

    @AutoInvoke(Phase.PLUGIN_RELOAD_OR_START)
    fun countRun(logger: Logger) {
        runs++
        logger.info("Statistics: run number $runs")
    }
}
