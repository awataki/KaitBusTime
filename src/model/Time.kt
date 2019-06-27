package model

import io.ktor.util.date.WeekDay
import java.time.LocalTime

data class Time(
    val id: Int,
    val time: LocalTime,
    val weekDay: WeekDay,
    val type: BusType,
    val from: BusStop,
    val to: BusStop
)

