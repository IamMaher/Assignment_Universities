plugins {
    id("core-compose-module")
}
dependencies {
    implementation(projects.core.di)
    api(libs.bundles.lifecycle)
    api(libs.coil)
}
