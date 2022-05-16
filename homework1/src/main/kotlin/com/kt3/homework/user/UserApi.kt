package com.kt3.homework.user

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
@Resource("/user")
class UserApi {

    @Serializable
    @Resource("")
    class Root(val parent: UserApi)

    @Serializable
    @Resource("/{userId}")
    class Id(val parent: UserApi = UserApi(), val userId: Long)
}
