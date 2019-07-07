package moe.yayoi.bus

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import io.ktor.routing.get

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(Locations)
    install(ContentNegotiation) { gson {} }
    install(Routing) {
        get("/") {
            call.response.status(HttpStatusCode.MethodNotAllowed)
        }
        getNext()
    }
}

