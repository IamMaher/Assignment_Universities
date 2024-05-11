plugins {
    id("core-compose-module")
}

dependencies {
    api(libs.retrofit)
    api(libs.retrofit.converter)
    api (libs.retrofit.interceptor)
    ksp(libs.retrofit.codegen)
}