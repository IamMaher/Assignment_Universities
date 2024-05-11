plugins {
    id("core-module")
}

android {
    buildFeatures.compose = true
    buildFeatures.viewBinding = true

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versionStr("compose.compiler")
    }
}

dependencies {
    //Compose
    api(platform(libs.library("compose.bom")))
    api(libs.bundle("compose"))
    api(libs.bundle("androidX"))
    debugApi(libs.bundle("compose.debug"))
}