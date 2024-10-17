# anthropic-sdk-kotlin-jvm-template

A Kotlin template repository which can be forked to use
[anthropic-sdk-kotlin](https://github.com/xemantic/anthropic-sdk-kotlin)
straight away in JVM environment.

You can use this project as a
[template repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template)
on GitHub.

After cloning, you can start using it straight away by opening
[ClaudeCanUseTools.kt](src/main/kotlin/ClaudeCanUseTools.kt) file and adjusting it to your needs.

Build the project with:
```shell
./gradlew build
```

Running:
```shell
./gradlew build fatJar
```

Will create
[build/libs/anthropic-sdk-kotlin-jvm-template-0.1-SNAPSHOT-fat.jar](build/libs/anthropic-sdk-kotlin-jvm-template-0.1-SNAPSHOT-fat.jar)

Which you can execute directly with:

```shell
java -jar anthropic-sdk-kotlin-jvm-template-0.1-SNAPSHOT-fat.jar
```

Follow `TODO` comments in the sourcecode for adjustments. Don't forget about changes to: 

* [settings.gradle.kts](settings.gradle.kts)
* [gradle.properties](gradle.properties)
* [build.gradle.kts](build.gradle.kts)
