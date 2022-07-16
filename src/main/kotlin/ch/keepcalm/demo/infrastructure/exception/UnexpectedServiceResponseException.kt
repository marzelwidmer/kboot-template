package ch.keepcalm.demo.infrastructure.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class UnexpectedServiceResponseException(message: String? = "Server is not responding.", cause: Throwable? = null) : RuntimeException(message, cause)
