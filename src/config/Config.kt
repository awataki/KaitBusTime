package config

class Config {
    companion object {
        const val DB_URI: String = "jdbc:mariadb://localhost:3306/bustime"
        const val DB_USER: String = "root"
        const val DB_PASSWORD: String = ""
    }
}