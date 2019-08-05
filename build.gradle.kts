repositories {
    jcenter()
    maven { setUrl("http://dl.bintray.com/jetbrains/intellij-plugin-service") }
}

plugins {
    java
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

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
