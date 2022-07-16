package ch.keepcalm.demo.infrastructure.api.complaint

import ch.keepcalm.demo.infrastructure.api.FileComplaintCommand
import ch.keepcalm.demo.infrastructure.api.IndexRootController
import ch.keepcalm.demo.infrastructure.persistence.mongodb.complaint.ComplaintQueryObject
import ch.keepcalm.demo.infrastructure.persistence.mongodb.complaint.ComplaintQueryObjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway
import org.jmolecules.architecture.onion.classical.InfrastructureRing
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.MediaTypes
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@InfrastructureRing
@RestController
class ComplaintAPI(private val repository: ComplaintQueryObjectRepository, private val commandGateway: ReactorCommandGateway) {


    @PostMapping("/api/complaint", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun fileComplaint(@RequestBody fileComplaintPayload: FileComplaintPayload): HttpEntity<Any> {
        val id = UUID.randomUUID().toString()
        commandGateway.send<String>(FileComplaintCommand(id = id, company = fileComplaintPayload.company, description = fileComplaintPayload.description)).awaitSingleOrNull()
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/api/complaint", produces = [MediaTypes.HAL_JSON_VALUE])
    suspend fun findAll(): Flow<ComplaintQueryObject> {
        return repository.findAll().asFlow()
//        return EntityModel.of(response, linkTo(methodOn(ComplaintAPI::class.java).findAll()).withSelfRel().toMono().awaitSingle())
//            .add(linkTo(methodOn(IndexRootController::class.java).index()).withRel(IanaLinkRelations.PREV).toMono().awaitSingle())
    }

    @GetMapping("/api/complaint/{id}", produces = [MediaTypes.HAL_JSON_VALUE])
    suspend fun find(@PathVariable id: String): ComplaintQueryObject? {
       return repository.findById(id).awaitSingle()

//        return EntityModel.of(response, linkTo(methodOn(ComplaintAPI::class.java).findAll()).withSelfRel().toMono().awaitSingle())
//            .add(linkTo(methodOn(IndexRootController::class.java).index()).withRel(IanaLinkRelations.PREV).toMono().awaitSingle())
    }
}
