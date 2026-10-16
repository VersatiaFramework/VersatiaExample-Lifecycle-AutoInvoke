package com.github.marcoral.versatia.example.autoinvoke

import com.github.marcoral.versatia.Phase
import com.github.marcoral.versatia.VersatiaPlugin
import com.github.marcoral.versatia.lifecycle.AutoInvoke

/** `onEnable` is final; lifecycle work is declared with `@AutoInvoke` instead. Private is fine. */
class AutoInvokePlugin : VersatiaPlugin() {
    @AutoInvoke(Phase.PLUGIN_RELOAD_OR_START)
    private fun hello(clock: Clock) = logger.info("started at ${clock.now()}")

    @AutoInvoke(Phase.PLUGIN_STOP)
    private fun goodbye() = logger.info("stopping")
}
