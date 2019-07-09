package model

enum class BusType(val value: Int) {
    DIRECT(0),
    ROUTE(1),
    SHUTTLE(2);

    companion object {
        fun fromID(i: Int): BusType {
            return BusType.values()[i]
        }
    }
}
