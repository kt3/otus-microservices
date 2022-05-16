package com.kt3.homework.plugins

import com.kt3.homework.server.userApi
import com.kt3.homework.user.UserApi
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configureRouting() {

    routing {
        get("/health") {
            call.respond(mapOf("status" to "OK"))
        }
        get("/") {
            call.respond("Hello world!")
        }

        userApi()
    }
}
