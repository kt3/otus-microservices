package com.kt3.homework.user.models

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

interface UserEntity : Entity<UserEntity> {
    companion object : Entity.Factory<UserEntity>()
    val id: Long
    var username: String?
    var firstName: String?
    var lastName: String?
    var email: String?
    var phone: String?
}

object Users : Table<UserEntity>("t_user") {
    val id = long("id").primaryKey().bindTo { it.id }
    val username = varchar("username").bindTo { it.username }
    val firstName = varchar("first_name").bindTo { it.firstName }
    val lastName = varchar("last_name").bindTo { it.lastName }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
}