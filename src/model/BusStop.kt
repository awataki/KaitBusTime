package model

enum class BusStop(i:Int) {
    CENTER(0),
    STATION(1),
    ODORI(2),
    SHORENJI(3),
    OGINOSINSYUKU(4),
    CAMPUS(5);
    companion object {
        fun fromID(i:Int):BusStop{return BusStop.values()[i]}
    }
}