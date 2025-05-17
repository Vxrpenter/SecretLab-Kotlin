import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish") version "0.32.0"
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
}

group = "dev.vxrp"
version = "0.3.0"

repositories {
    mavenCentral()
}

val serializationVersion = "1.7.3"
val gsonVersion = "2.11.0"
val okHttp3Version = "4.12.0"
val logbackVersion = "1.5.18"

dependencies {
    implementation("com.squareup.okhttp3:okhttp:$okHttp3Version")
    implementation("com.google.code.gson:gson:$gsonVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "secretlab-kotlin")

    pom {
        name = "SecretLab Kotlin"
        description = "A Scp-Secret-Laboratory api wrapper"
        inceptionYear = "2025"
        url = "https://github.com/Vxrpenter/SecretLab-Kotlin"
        licenses {
            license {
                name = "MIT License"
                url = "https://opensource.org/license/mit"
            }
        }
        developers {
            developer {
                name = "Vxrpenter"
                url = "https://github.com/Vxrpenter"
            }
        }
        scm {
            url = "https://github.com/Vxrpenter/SecretLab-Kotlin"
            connection = "scm:git:git://github.com/Vxrpenter/SecretLab-Kotlin.git"
            developerConnection = "scm:git:ssh://git@github.com/Vxrpenter/SecretLab-Kotlin.git"
        }
    }
}
