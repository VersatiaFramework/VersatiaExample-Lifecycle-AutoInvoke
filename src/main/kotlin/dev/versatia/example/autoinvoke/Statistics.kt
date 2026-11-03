package dev.versatia.example.autoinvoke

import dev.versatia.Phase
import dev.versatia.lifecycle.AutoInvoke
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
