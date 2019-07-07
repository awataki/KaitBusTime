package module

import model.Direction
import model.Time
import module.`interface`.TimeModuleInterface
import org.slf4j.LoggerFactory
import repository.msqyl.TimeRepositoryInterface

class TimeModule(val tr: TimeRepositoryInterface) : TimeModuleInterface {
    val log = LoggerFactory.getILoggerFactory()
    override fun getNextTime(direction: Direction): Time {
        val res = kotlin.runCatching {
            tr.findNext(direction)
        }

        if (res.isSuccess) {
            return res.getOrNull() ?: throw NullPointerException()
        } else {
            throw res.exceptionOrNull() ?: throw NullPointerException()
        }
    }

    override fun getTimeFromID(): Time {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}