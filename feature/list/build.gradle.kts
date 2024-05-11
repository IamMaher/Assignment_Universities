plugins {
    id("feature-module")
    alias(libs.plugins.kotlin.android)
}
dependencies {
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.constraintlayout)

    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.core.di)
    implementation(projects.core.network)
    implementation(projects.core.database)

    ksp(libs.dagger.compiler)

    implementation(projects.feature.details)
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
