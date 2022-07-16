package ch.keepcalm.demo.infrastructure.configuration.axon

import mu.KotlinLogging
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class AxonEventLogger {

    private val axonEventLogger = KotlinLogging.logger("axon-event-logger")

    @EventHandler
    fun on(any: Any) {
        axonEventLogger.info("logType=axon-event handling event: {}", any.javaClass.simpleName)
    }
}
