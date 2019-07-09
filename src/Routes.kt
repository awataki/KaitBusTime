package moe.yayoi.bus

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import model.Direction
import module.TimeModule
import moe.yayoi.bus.model.json.TimeJson
import org.slf4j.LoggerFactory
import repository.msqyl.TimeRepository
import util.DBUtil

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
            val time = tm.getNextTime(d)
            val json = TimeJson(
                time.id,
                time.time,
                time.weekDay.value,
                time.type.value,
                time.from.value,
                time.to.value
            )
            call.respond(json)
        } catch (e: ArrayIndexOutOfBoundsException) {
            call.response.status(HttpStatusCode.BadRequest)
        } catch (e: Exception) {
            log.error(e.message)
            e.printStackTrace()
            call.response.status(HttpStatusCode.InternalServerError)
        }
    }
}