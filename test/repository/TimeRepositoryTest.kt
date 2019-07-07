package moe.yayoi.bus.repository

import io.ktor.util.date.WeekDay
import model.BusStop
import model.BusType
import model.Time
import exception.NoDataException
import model.WeekType
import repository.msqyl.TimeRepository
import repository.msqyl.TimeRepositoryInterface
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TimeRepositoryTest {
    @Test
    fun findNext() {
        val conn = java.sql.DriverManager.getConnection("jdbc:mariadb://localhost:3306/bustime", "root", "")
        val fr = TimeRepository(conn)
        val ac = Time(1, LocalTime.of(23, 59), WeekType.BOTH, BusType.DIRECT, BusStop.CENTER, BusStop.ODORI)
        val ex: Result<Time> = kotlin.runCatching {
            fr.findNext()
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
    fun findOneTest() {
        val conn = java.sql.DriverManager.getConnection("jdbc:mariadb://localhost:3306/bustime", "root", "")
        val fr: TimeRepositoryInterface = TimeRepository(conn)
        // try TrueCase
        val ac = Time(0, LocalTime.of(1, 20), WeekType.BOTH, BusType.DIRECT, BusStop.CENTER, BusStop.ODORI)
        var ex: Result<Time?> = kotlin.runCatching {
            fr.findOne(0)
        }

        if (ex.isSuccess) {
            assertEquals(ac, ex.getOrNull())
        } else {
            val e = ex.exceptionOrNull()
            e?.printStackTrace()
        }

        // try InvalidCase

        // No found exception
        ex = kotlin.runCatching {
            // Invalid Value
            fr.findOne(9999)
        }
        if (ex.isSuccess) {
            fail("actual fail FIndOne() but yet")
        } else {
            val e = ex.exceptionOrNull() as? NoDataException ?: fail("Excepted invalid error")
        }
    }
}