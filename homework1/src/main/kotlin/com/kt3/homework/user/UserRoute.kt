package com.kt3.homework.user

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
@Resource("/user")
class UserRoute {

    @Serializable
    @Resource("")
    class Root(val parent: UserRoute)

    @Serializable
    @Resource("/{userId}")
    class Id(val parent: UserRoute = UserRoute(), val userId: Long)
}
