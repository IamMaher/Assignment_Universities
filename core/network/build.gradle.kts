plugins {
    id("core-compose-module")
}

dependencies {
    api(libs.retrofit)
    api(libs.retrofit.converter)
    api (libs.retrofit.interceptor)
    api(libs.retrofit.moshi)
    ksp(libs.retrofit.codegen)
}