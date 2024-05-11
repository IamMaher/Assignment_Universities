pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "Universities"

include(":app")
include(":core:ui")
include(":core:navigation")
include(":core:domain")
include(":core:coroutines")
include(":core:di")
include(":core:network")
include(":core:database")
include(":core:util")
