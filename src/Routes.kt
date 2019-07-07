package moe.yayoi.bus.routes

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import model.Direction
import module.TimeModule
import org.slf4j.LoggerFactory
import repository.msqyl.TimeRepository
import util.DBUtil
import java.lang.Exception

fun Route.getById() {
    get("/get/{userId}/") {
        // no implements
    }
}

fun Route.getNext() {
    val log = LoggerFactory.getILoggerFactory().getLogger("Route /getNext:")

    @Location("/get/next")
    data class findNext(val direction: Int = -1)
    get<findNext> {
        try {
            val d: Direction = Direction.fromID(it.direction)
            val tr = TimeRepository(DBUtil().connect())
            val tm = TimeModule(tr)

            call.respond(tm.getNextTime(d))
        } catch (e: ArrayIndexOutOfBoundsException) {
            call.response.status(HttpStatusCode.BadRequest)
        } catch (e: Exception) {
            log.error(e.message)
            e.printStackTrace()
            call.response.status(HttpStatusCode.InternalServerError)
        }
    }
}