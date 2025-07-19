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

dependencies {
    implementation(project(":pluginbase-core"))
}