include(
    ":pluginbase-core",
    ":pluginbase-games",
    ":pluginbase-mongo",
    ":pluginbase-redis",
    ":pluginbase-sql"
)

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            files("gradle/libs.versions.toml")
        }
    }
}