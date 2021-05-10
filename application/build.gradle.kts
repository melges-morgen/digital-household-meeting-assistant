plugins {
    kotlin("jvm") version "1.5.0"
}

version = "unspecified"

repositories {
    mavenCentral()
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-server-core:1.5.4")
    implementation("io.ktor:ktor-server-netty:1.5.4")

    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.kodein.di:kodein-di-jvm:7.5.0")
}