import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    alias(libs.plugins.shadow)
}

tasks {
    named<Jar>("jar") {
        enabled = false
    }

    named<ShadowJar>("shadowJar") {
        dependsOn(project(":pluginbase-core").tasks.named("shadowJar"))
        archiveClassifier.set("")
    }

    named("build") {
        dependsOn(named("shadowJar"))
    }
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation(project(":pluginbase-core"))
    implementation(libs.deps.hikaricp)
    implementation(libs.deps.sqlstreams)
}