import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    alias(libs.plugins.shadow)
}

tasks {
    named<Jar>("jar") {
        enabled = false
    }

    named<ShadowJar>("shadowJar") {
        archiveClassifier.set("")
    }

    named("build") {
        dependsOn(named("shadowJar"))
    }
}

dependencies {
    implementation(libs.deps.authlib)
    implementation(libs.deps.adventure.bukkit)
    implementation(libs.deps.xseries)
    implementation(libs.deps.experingmap)
}