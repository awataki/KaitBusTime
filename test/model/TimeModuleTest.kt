package moe.yayoi.bus.model

import model.Direction
import model.Time
import module.TimeModule
import module.`interface`.TimeModuleInterface
import repository.msqyl.TimeRepositoryInterface
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail


class TimeModuleTest {
    private val tr = DummyTimeRepo()
    @Test
    fun getNext() {
        val tm: TimeModuleInterface = TimeModule(tr)
        var d: Direction = Direction.CAMPUS
        val ac = Time(0, LocalTime.of(0, 0))

        // 正常ケース
        var res = kotlin.runCatching {
            tm.getNextTime(d)
        }
        if (res.isSuccess) {
            val ex: Time? = res.getOrNull()
            assertEquals(ex, ac)
        } else {
            fail("actual success getNextTime() but yet")
        }

        d = Direction.STATION
        res = kotlin.runCatching {
            tm.getNextTime(d)
        }
        if (res.isSuccess) {
            val ex: Time? = res.getOrNull()
            assertEquals(ex, ac)
        } else {
            fail("actual success getNextTime() but yet")
        }
    }

    private inner class DummyTimeRepo : TimeRepositoryInterface {
        override fun findNext(direction: Direction): Time {
            return Time(0, LocalTime.of(0, 0))
        }

        override fun findOne(id: Int): Time {
            return Time(0, LocalTime.of(0, 0))
        }

    }
}