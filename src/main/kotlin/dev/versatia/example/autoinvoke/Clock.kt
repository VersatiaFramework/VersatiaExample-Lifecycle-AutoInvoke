package dev.versatia.example.autoinvoke

import dev.versatia.Phase
import dev.versatia.di.LocalBean
import dev.versatia.lifecycle.AutoInvoke
import java.time.Instant

@LocalBean
class Clock {
    fun now() = Instant.now()

    /** A function of a bean is called on the bean instance, once every bean exists. */
    @AutoInvoke(Phase.PLUGIN_START_ONLY)
    fun announce(plugin: AutoInvokePlugin) = plugin.logger.info("Clock.announce(): bean function, ${plugin.name} injected")
}
