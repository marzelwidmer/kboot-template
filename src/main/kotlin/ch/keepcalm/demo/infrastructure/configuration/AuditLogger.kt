package ch.keepcalm.demo.infrastructure.configuration

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class AuditLogger {

    companion object {
        val auditLogger = KotlinLogging.logger("audit-logger")
    }
}
