plugins {
    id("feature-module")
    alias(libs.plugins.kotlin.android)
}

android {

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    implementation(libs.bundles.navigation)
}
