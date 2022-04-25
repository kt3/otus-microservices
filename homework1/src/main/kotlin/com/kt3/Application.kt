package com.kt3

import com.kt3.plugins.configureRouting
import com.kt3.plugins.configureSerialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8000, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
