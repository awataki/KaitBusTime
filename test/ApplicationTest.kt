package moe.yayoi.bus

import com.google.gson.Gson
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.MethodNotAllowed, response.status())
            }
            handleRequest(HttpMethod.Get, "/get/999").apply {
                val gson = Gson()
                assertEquals(HttpStatusCode.OK, response.status())
                // TODO Insert Test Data
                assertEquals(gson.toJson("Test Data Here"), response.content)
            }
        }
    }
}
