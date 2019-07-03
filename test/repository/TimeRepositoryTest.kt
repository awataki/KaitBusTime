package moe.yayoi.bus.repository

import io.ktor.util.date.WeekDay
import model.BusStop
import model.BusType
import model.Time
import Exception.NoDataException
import repository.TimeRepository
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TimeRepositoryTest {
    @Test
    fun FindNext() {
        val conn = java.sql.DriverManager.getConnection("url here")
        val fr = TimeRepository(conn)
        val ac = Time(0, LocalTime.of(1, 20), WeekDay.MONDAY, BusType.DIRECT, BusStop.CENTER, BusStop.ODORI)
        val ex: Result<Time> = kotlin.runCatching {
            fr.FindNext(LocalTime.now())
        }

        if (ex.isSuccess) {
            assertEquals(ac, ex.getOrNull())
        } else {
            val e = ex.exceptionOrNull()
            e?.printStackTrace()
            fail("actual Success but yet")

        }
    }

    @Test
    fun FindOneTest() {
        val conn = java.sql.DriverManager.getConnection("url here")
        val fr = TimeRepository(conn)
        // try TrueCase
        val ac = Time(0, LocalTime.of(1, 20), WeekDay.MONDAY, BusType.DIRECT, BusStop.CENTER, BusStop.ODORI)
        var ex: Result<Time> = kotlin.runCatching {
            fr.FindOne(0)
        }

        if (ex.isSuccess) {
            assertEquals(ac, ex.getOrNull())
        } else {
            val e = ex.exceptionOrNull()
            e?.printStackTrace()
        }

        // try InvalidCase

        // No found Exception
        ex = kotlin.runCatching {
            // Invalid Value
            fr.FindOne(9999)
        }
        if (ex.isSuccess) {
            fail("actual fail FIndOne() but yet")
        } else {
            val e = ex.exceptionOrNull() as? NoDataException ?: fail("Excepted invalid error")
        }
    }
}