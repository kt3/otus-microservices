package com.kt3.homework.user

import com.kt3.homework.user.models.ErrorResponse
import com.kt3.homework.user.models.User
import com.kt3.homework.user.models.UserEntity
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.resources.delete
import io.ktor.server.resources.get
import io.ktor.server.resources.post
import io.ktor.server.resources.put
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing

fun Routing.userApi() {

    val userService = UserService

    post<UserRoute.Root> {
        val user = call.receive<User>()
        val userEntity: UserEntity = user.toEntity().also {
            userService.createUser(it)
        }
        call.respond(userEntity.toModel())
    }

    get<UserRoute.Id> { id ->
        userService.getUser(id.userId)?.let {
            call.respond(it.toModel())
        } ?: call.respond(
            HttpStatusCode.NotFound,
            ErrorResponse(1, "User with id = $id hasn't been found")
        )
    }

    delete<UserRoute.Id> { id ->
        userService.deleteUser(id.userId)
        call.respond(HttpStatusCode.NoContent)
    }

    put<UserRoute.Id> { id ->
        call.receive<User>().apply {
            userService.updateUser(id.userId, toEntity())
        }
        call.respond(HttpStatusCode.OK)
    }
}

private fun UserEntity.toModel() = User(
    id = id,
    username = username,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone
)

private fun User.toEntity(): UserEntity = let {
    UserEntity {
        username = it.username
        firstName = it.firstName
        lastName = it.lastName
        email = it.email
        phone = it.phone
    }
}
