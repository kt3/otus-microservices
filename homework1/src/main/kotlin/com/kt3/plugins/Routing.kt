package com.kt3.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {

    routing {
        get("/health") {
            call.respond(mapOf("status" to "OK"))
        }
    }
}
