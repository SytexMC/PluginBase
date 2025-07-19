allprojects {
    apply {
        plugin("java-library")
    }

    group = "me.sytex"
    version = "0.0.1-SNAPSHOT"

    extra["javaToolchainVersion"] = 21
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    extensions.configure<JavaPluginExtension> {
        toolchain.languageVersion.set(
            JavaLanguageVersion.of(
                (extra["javaToolchainVersion"] as? Int) ?: 21 // fallback version 21
            )
        )
    }

    plugins.withType<JavaPlugin> {
        dependencies { // Version catalog not available in root project
            add("compileOnly", "io.papermc.paper:paper-api:1.21.7-R0.1-SNAPSHOT")
            add("compileOnly", "org.projectlombok:lombok:1.18.38")
            add("annotationProcessor", "org.projectlombok:lombok:1.18.38")
        }

        tasks.named<JavaCompile>("compileJava") {
            options.encoding = "UTF-8" // We want UTF-8 for everything
        }

        tasks.named<ProcessResources>("processResources") {
            filteringCharset = "UTF-8" // We want UTF-8 for everything
        }
    }
}
