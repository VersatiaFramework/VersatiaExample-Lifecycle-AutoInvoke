# VersatiaExample-Lifecycle-AutoInvoke

Functions run at start, reload or stop with their parameters injected: on the main class, on a bean and on an object.

Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Auto-invoked functions](https://versatiaframework.github.io/VersatiaDocs/docs/lifecycle/auto-invoke).

**Start with** [`AutoInvokePlugin.kt`](src/main/kotlin/com/github/marcoral/versatia/example/autoinvoke/AutoInvokePlugin.kt).

## What the log shows

```
[VersatiaExample-Lifecycle-AutoInvoke] started at ...
[VersatiaExample-Lifecycle-AutoInvoke] Clock.announce(): bean function, VersatiaExample-Lifecycle-AutoInvoke injected
[VersatiaExample-Lifecycle-AutoInvoke] Statistics: run number 1
(on disable) [VersatiaExample-Lifecycle-AutoInvoke] stopping
```

## Things to try

- Change `hello` to `PLUGIN_START_ONLY` and run `/versatia reload VersatiaExample-Lifecycle-AutoInvoke`:
  `hello` no longer runs, while `Statistics.countRun` logs `run number 2`. A server restart is a
  new start, not a reload, so it runs `hello` again and counts from 1.
- Give `goodbye` a `clock: Clock` parameter: beans live as long as the plugin, so the function
  receives at stop the same `Clock` that was created at start.

## Building

Requires JDK 21 and VersatiaStarter with what it exports (VersatiaAPI, the module APIs) in your
local Maven repository (`./gradlew publishToMavenLocal` in each checkout; see
[Building the framework](https://versatiaframework.github.io/VersatiaDocs/docs/contributing/building));
running it requires a Paper 1.21.4 server with VersatiaCore installed, and the
[CommandAPI](https://commandapi.jorel.dev) 12.x plugin for `/versatia reload`.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
