package moe.yayoi.bus

import com.google.gson.Gson
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import model.BusStop
import model.BusType
import model.Time
import model.WeekType
import java.time.LocalTime

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.MethodNotAllowed, response.status())
            }
//            handleRequest(HttpMethod.Get, "/get/999").apply {
//                val gson = Gson()
//                assertEquals(HttpStatusCode.OK, response.status())
//                // TODO Insert Test Data
//                assertEquals(gson.toJson("Test Data Here"), response.content)
//            }
            handleRequest(HttpMethod.Get, "/get/next?direction=0").apply {
                val gson = Gson()
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    gson.toJson(
                        Time(
                            1,
                            LocalTime.of(23, 59),
                            WeekType.BOTH,
                            BusType.DIRECT,
                            BusStop.CENTER,
                            BusStop.ODORI
                        )
                    ), response.content
                )
            }
        }
    }
}
