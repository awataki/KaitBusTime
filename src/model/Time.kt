package model

import io.ktor.util.date.WeekDay
import java.time.LocalTime

data class Time(
    val ID: Int,
    val Time: LocalTime,
    val WeekDay: WeekDay
)