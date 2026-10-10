package com.github.marcoral.versatia.example.autoinvoke

import com.github.marcoral.versatia.EventType
import com.github.marcoral.versatia.di.LocalBean
import com.github.marcoral.versatia.lifecycle.AutoInvoke
import java.time.Instant

@LocalBean
class Clock {
    fun now() = Instant.now()

    /** A function of a bean is called on the bean instance, once every bean exists. */
    @AutoInvoke(EventType.PLUGIN_START_ONLY)
    fun announce(plugin: AutoInvokePlugin) = log("bean function, ${plugin.name} injected")
}
