package ch.keepcalm.demo.infrastructure.persistence.mongodb.complaint

import ch.keepcalm.demo.domain.ComplaintFileEvent
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component
import mu.KLogging
import mu.KotlinLogging

@Component
class ComplaintQueryObjectUpdater(private val repository: ComplaintQueryObjectRepository) : KLogging() {

    private val axonEventLogger = KotlinLogging.logger("axon-event-logger")

    @EventHandler
    fun handle(event: ComplaintFileEvent) {
        val complaintQueryObject = ComplaintQueryObject(id = event.complaintId, company = event.complaintId, description = event.description)
        axonEventLogger.info("logType=axon-event handling event: {}", event.javaClass.simpleName)
        repository.save(complaintQueryObject).subscribe()
    }
}
