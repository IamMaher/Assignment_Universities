plugins {
    id("core-compose-module")
}

dependencies {
    api(libs.dagger.android)
    ksp(libs.dagger.compiler)
    api(projects.core.network)
    api(projects.core.database)
}