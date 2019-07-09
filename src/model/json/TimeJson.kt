package moe.yayoi.bus.model.json

import model.BusStop
import model.BusType
import model.WeekType

import java.time.LocalTime

data class TimeJson(
    val id: Int = 0,
    val time: LocalTime = LocalTime.now(),
    val weekDay: Int = WeekType.BOTH.value,
    val type: Int = BusType.DIRECT.value,
    val from: Int = BusStop.STATION.value,
    val to: Int = BusStop.STATION.value
)

