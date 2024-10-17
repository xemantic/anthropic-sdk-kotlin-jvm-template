plugins {
  kotlin("jvm") version "2.0.21"
  kotlin("plugin.serialization") version "2.0.21" // needed if you use tools
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.xemantic.anthropic:anthropic-sdk-kotlin:0.4.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.7.3")
  implementation("io.ktor:ktor-client-java:3.0.0")
  implementation("org.slf4j:slf4j-simple:2.0.16")
}

application {
  // TODO update with your package and application name
  mainClass.set("com.xemantic.anthropic.demo.ClaudeCanUseToolsKt")
}

tasks.register<Jar>("fatJar") {
  archiveClassifier.set("fat")

  from(sourceSets.main.get().output)

  dependsOn(configurations.runtimeClasspath)
  from({
    configurations.runtimeClasspath.get().filter {
      it.name.endsWith("jar")
    }.map {
      zipTree(it)
    }
  })

  manifest {
    attributes["Main-Class"] = application.mainClass
  }

  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
