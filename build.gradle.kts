import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build362"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "me.mikhail"
version = "1.0"
val ktor_version  = "1.6.4"

repositories {
    mavenLocal()
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}



    dependencies {
        //ui framework
        implementation(compose.desktop.currentOs)
        //library to make http requests
        implementation("io.ktor:ktor-client-core:$ktor_version")
        //engine for above library
        implementation("io.ktor:ktor-client-apache:$ktor_version")
        //library to create sslContext
        implementation("io.github.hakky54:sslcontext-kickstart:7.0.2")
        //library to create trust material for ssl context from .pem files
        implementation("io.github.hakky54:sslcontext-kickstart-for-pem:7.0.2")
        //library to parse json
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
        //library to use above library in http requests
        implementation("io.ktor:ktor-client-serialization:$ktor_version")
        //logging library
        implementation("ch.qos.logback:logback-classic:1.2.6")
        //library to use above library in http requests
        implementation("io.ktor:ktor-client-logging:$ktor_version")
        //library to write multithreaded code (to act on http responses without blocking thread)
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "11"
    }

    compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "RazerController"
            packageVersion = "1.0.0"
        }
    }
}

