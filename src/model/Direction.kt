package model

enum class Direction(val value: kotlin.Int) {
    CAMPUS(0),
    STATION(1);

    companion object {
        fun fromID(i: Int): Direction {
            return Direction.values()[i]
        }
    }
}