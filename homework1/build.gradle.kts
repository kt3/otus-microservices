val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("org.openapi.generator") version "5.3.0"
}

group = "com.kt3"
version = "0.0.1"

val generatedSources = file("$buildDir/generate-resources/main/src/kotlin")

kotlin.sourceSets{
    main {
        kotlin.srcDirs += generatedSources
    }
}

application {
    mainClass.set("com.kt3.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

openApiGenerate {
    generatorName.set("kotlin-server")
    packageName.set("com.kt3.homework")
    inputSpec.set("$rootDir/otus55-users.yaml")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
//    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
//    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-resources:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}