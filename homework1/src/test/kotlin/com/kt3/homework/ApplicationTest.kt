package com.kt3.homework

import com.kt3.homework.plugins.configureRouting
import com.kt3.homework.plugins.configureSerialization
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.install
import io.ktor.server.config.ApplicationConfig
import io.ktor.server.resources.Resources
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testHealth() = testApplication {
        application {
            install(Resources)
            configureRouting()
            configureSerialization()
        }
        environment {
            config = ApplicationConfig("application-test.conf")
        }
        client.get("/health") {
            accept(ContentType.Application.Json)
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}
