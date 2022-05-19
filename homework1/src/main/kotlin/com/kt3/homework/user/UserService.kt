package com.kt3.homework.user

import com.kt3.homework.config.DatabaseFactory
import com.kt3.homework.user.models.UserEntity
import com.kt3.homework.user.models.Users
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf

object UserService {

    private val db by lazy { DatabaseFactory.database }

    private val Database.users get() = this.sequenceOf(Users)

    fun createUser(user: UserEntity) {
        db.useTransaction {
            db.users.add(user)
        }
    }

    fun getUser(id: Long): UserEntity? = db.users.find { it.id eq id }

    fun updateUser(id: Long, user: UserEntity) {
        db.useTransaction {
            val foundUser = getUser(id)
            foundUser?.apply {
                firstName = user.firstName ?: firstName
                lastName = user.lastName ?: lastName
                username = user.username ?: username
                email = user.username ?: username
                phone = user.phone ?: phone
            }
        }
    }

    fun deleteUser(id: Long) {
        db.useTransaction {
            getUser(id)?.delete()
        }
    }
}