package com.kt3.homework

import com.kt3.homework.plugins.configureRouting
import com.kt3.homework.plugins.configureSerialization
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.resources.Resources

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(Resources)
    configureRouting()
    configureSerialization()
}
