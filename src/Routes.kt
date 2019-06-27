package moe.yayoi.bus.routes

import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.GetById() {
    get("/get/{userId}/") {
        // no implements
    }
}