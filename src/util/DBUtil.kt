package util

import config.Config
import exception.DBConnectException
import java.sql.Connection

class DBUtil {
    private val Address = Config.DB_URI
    private val DBUser = Config.DB_USER
    private val DBPassword = Config.DB_PASSWORD
    private val db = java.sql.DriverManager.getConnection(Address, DBUser, DBPassword)

    fun connect(): Connection {
        return this.db ?: throw DBConnectException()
    }
}