import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    jcenter()
    maven { setUrl("http://dl.bintray.com/jetbrains/intellij-plugin-service") }
}

plugins {
    java
    kotlin("jvm") version "1.3.41"
    id("org.jetbrains.intellij") version "0.4.9"
}

dependencies {
    testCompile("junit:junit:4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    // Define IntelliJ Platform API version to use for building this plugin
    version = "2019.1"
}

tasks {

    patchPluginXml {
        untilBuild("201.*")
        setVersion(project.version)
    }
}

tasks.withType<KotlinCompile> {
    sourceCompatibility = JvmTarget.JVM_1_8.name
    targetCompatibility = sourceCompatibility
    kotlinOptions.suppressWarnings = true
}