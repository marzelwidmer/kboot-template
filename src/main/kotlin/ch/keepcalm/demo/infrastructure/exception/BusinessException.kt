package ch.keepcalm.demo.infrastructure.exception

open class BusinessException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
