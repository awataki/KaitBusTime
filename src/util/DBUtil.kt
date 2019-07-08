package util

import config.Config
import exception.DBConnectException
import java.sql.Connection

class DBUtil {
    private val dbURI = Config.DB_URI
    private val dbUser = Config.DB_USER
    private val dbPassword = Config.DB_PASSWORD
    private val db = java.sql.DriverManager.getConnection(dbURI, dbUser, dbPassword)

    fun connect(): Connection {
        return this.db ?: throw DBConnectException()
    }
}