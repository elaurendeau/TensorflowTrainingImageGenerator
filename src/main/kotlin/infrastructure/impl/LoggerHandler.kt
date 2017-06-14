package infrastructure.impl

import enumeration.LoggingLevelEnumeration
import infrastructure.ILoggerHandler
import org.apache.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class LoggerHandler: ILoggerHandler {
    val logger = LogManager.getLogger(this.javaClass)
    override fun log(level: LoggingLevelEnumeration, message: String) {
        when(level) {
            LoggingLevelEnumeration.INFO -> if(logger.isInfoEnabled) logger.info(message)
            LoggingLevelEnumeration.DEBUG -> if(logger.isDebugEnabled) logger.debug(message)
        }
    }
}