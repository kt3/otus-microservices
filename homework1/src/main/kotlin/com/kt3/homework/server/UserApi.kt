package com.kt3.homework.server

import com.kt3.homework.user.UserApi
import com.kt3.homework.user.models.User
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.resources.get
import io.ktor.server.response.respond
import io.ktor.server.resources.post
import io.ktor.server.resources.put
import io.ktor.server.resources.delete
import io.ktor.server.routing.Routing

fun Routing.userApi() {

    post<UserApi.Root> {
        val user = call.receive<User>()
        call.respond(
            User(
                id = user.id,
                username = user.username,
                firstName = user.firstName
            )
        )
    }

    get<UserApi.Id> { id ->
        call.respond(id.userId)
    }

    delete<UserApi.Id> {
        call.respond(HttpStatusCode.NotImplemented)
    }

    put<UserApi.Id> {
        call.respond(HttpStatusCode.NotImplemented)
    }
}