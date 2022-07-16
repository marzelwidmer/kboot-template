package ch.keepcalm.demo.application

import ch.keepcalm.demo.domain.ComplaintFileEvent
import ch.keepcalm.demo.infrastructure.api.FileComplaintCommand
import io.jsonwebtoken.lang.Assert
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Complaint {

    @AggregateIdentifier
    private lateinit var complaintId: String

    constructor()

    @CommandHandler
    constructor(command: FileComplaintCommand) {
        Assert.hasLength(command.company)
        AggregateLifecycle.apply(
            ComplaintFileEvent(complaintId = command.id, company = command.company, description = command.description)
        )
    }

    @EventSourcingHandler
    fun on(event: ComplaintFileEvent) {
        complaintId = event.complaintId
    }
}
