plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.gradle)
    implementation(libs.gradle.api)
    implementation(libs.ksp.plugin)
}

tasks.test {
    useJUnitPlatform()
}
