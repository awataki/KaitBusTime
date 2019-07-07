package repository.msqyl

import model.Direction
import model.Time

interface TimeRepositoryInterface {
    fun findNext(direction: Direction): Time
    fun findOne(id: Int): Time
}