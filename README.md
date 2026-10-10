    # VersatiaExample-Lifecycle-AutoInvoke

    Functions run at start, reload or stop with their parameters injected: on the main class, on a bean and on an object.

    Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Auto-invoked functions](https://versatiaframework.github.io/VersatiaDocs/docs/lifecycle/auto-invoke).

    **Start with** [`AutoInvokePlugin.kt`](src/main/kotlin/com/github/marcoral/versatia/example/autoinvoke/AutoInvokePlugin.kt).

    ## What the log shows

    ```
    [Clock] bean function, VersatiaExample-Lifecycle-AutoInvoke injected
[Statistics] start number 1
started at ...
(on disable) stopping
    ```


## Things to try

- Change `hello` to `PLUGIN_START_ONLY` and reload the server: it no longer runs on reload while
  `Statistics.countStart` still does.
- Give `goodbye` a parameter: beans are gone at stop, so the plugin fails to disable cleanly with a
  message naming the function.

## Building

Requires JDK 21 and VersatiaAPI in your local Maven repository (`./gradlew publishToMavenLocal`
in its checkout); running it requires a Paper 1.21.4 server with VersatiaCore installed.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
