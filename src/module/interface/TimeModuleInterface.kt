package module.`interface`

import model.Direction
import model.Time

interface TimeModuleInterface {
    fun getNextTime(direction: Direction): Time
    fun getTimeFromID(): Time
}