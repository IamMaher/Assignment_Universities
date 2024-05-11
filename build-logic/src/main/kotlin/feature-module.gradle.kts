plugins {
    id("core-module")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildFeatures.compose = true
    buildFeatures.viewBinding = true

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versionStr("compose.compiler")
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":core:domain"))
    implementation(project(":core:util"))

    implementation(libs.bundle("lifecycle"))
    implementation(libs.library("coil"))
    implementation(libs.library("activity.ktx"))
}