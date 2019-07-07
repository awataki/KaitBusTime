package model

import java.time.LocalTime

data class Time(
    val id: Int = 0,
    val time: LocalTime = LocalTime.now(),
    val weekDay: WeekType = WeekType.BOTH,
    val type: BusType = BusType.DIRECT,
    val from: BusStop = BusStop.STATION,
    val to: BusStop = BusStop.STATION
)

