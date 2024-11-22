plugins {
    java
    kotlin("jvm") version "2.0.20"
}

group = "dev.vxrp"
version = "1.0"

repositories {
    mavenCentral()
}

val gsonVersion = "2.11.0"
val okHttp3Version = "4.12.0"

dependencies {
    implementation("com.squareup.okhttp3:okhttp:$okHttp3Version")
    implementation("com.google.code.gson:gson:$gsonVersion")
}