package model

enum class WeekType(val value: kotlin.Int) {
    WEEKDAY(0),
    HOLIDAY(1),
    BOTH(2);

    companion object {
        fun fromValue(i: Int): WeekType {
            return WeekType.values()[i]
        }
    }
}
