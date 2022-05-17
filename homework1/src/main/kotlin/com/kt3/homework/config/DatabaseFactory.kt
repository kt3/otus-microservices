package com.kt3.homework.config

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.HoconApplicationConfig
import org.flywaydb.core.Flyway
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel

object DatabaseFactory {

    private val appConfig = HoconApplicationConfig(ConfigFactory.load())
    private val dbUrl = appConfig.property("db.jdbcUrl").getString()
    private val dbUser = appConfig.property("db.dbUser").getString()
    private val dbPassword = appConfig.property("db.dbPassword").getString()

    val database by lazy {
        Database.connect(
            hikari,
            logger = ConsoleLogger(LogLevel.INFO)
        ).also {
            flyway.migrate()
        }
    }

    private val hikari by lazy {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = dbUrl
        config.username = dbUser
        config.password = dbPassword
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        HikariDataSource(config)
    }

    private val flyway: Flyway by lazy {
        Flyway
            .configure()
            .dataSource(dbUrl, dbUser, dbPassword)
            .load()
    }
}
