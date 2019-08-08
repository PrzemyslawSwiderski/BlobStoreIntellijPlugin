repositories {
    jcenter()
    mavenCentral()
}

plugins {
    java
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

dependencies {
    implementation("org.apache.jclouds.api:filesystem:2.1.2")
    implementation("org.apache.jclouds:jclouds-core:2.1.2")
}

tasks {
    shadowJar {
        relocate("com.google", "org.jclouds.shaded")
    }
}