plugins {
    `maven-publish`
    java
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
}

group = "dev.vxrp"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

val serializationVersion = "1.7.3"
val gsonVersion = "2.11.0"
val okHttp3Version = "4.12.0"

dependencies {
    implementation("com.squareup.okhttp3:okhttp:$okHttp3Version")
    implementation("com.google.code.gson:gson:$gsonVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
}


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name = "SLA-Tools"
                description = "A small library for accessing the SecretLab, Cedmod and Scplist api for the game Scp Secret Laboratory"
                url = "https://github.com/Vxrpenter/SecretLab-Api-Tools"
                licenses {
                    license {
                        name = "The MIT License"
                        url = "https://github.com/Vxrpenter/SecretLab-Api-Tools/blob/main/LICENSE"
                        distribution = "repo"
                    }
                }
                developers {
                    developer {
                        id = "Vxrpenter"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/Vxrpenter/SecretLab-Api-Tools"
                    developerConnection = "scm:git:ssh://github.com/Vxrpenter/SecretLab-Api-Tools"
                    url = "https://github.com/Vxrpenter/SecretLab-Api-Tools/"
                }
            }
        }
    }
}