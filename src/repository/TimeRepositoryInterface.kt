package repository.msqyl

import model.Time

interface TimeRepositoryInterface {
    fun findNext(): Time
    fun findOne(id: Int): Time
}