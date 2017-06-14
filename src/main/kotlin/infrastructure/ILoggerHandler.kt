package infrastructure

import enumeration.LoggingLevelEnumeration

interface ILoggerHandler {
    fun log(level: LoggingLevelEnumeration, message: String)
}