package module

import model.Direction

interface TimeModuleInterface {
    fun getNextTime(direction: Direction)
    fun getTimeFromID()
}