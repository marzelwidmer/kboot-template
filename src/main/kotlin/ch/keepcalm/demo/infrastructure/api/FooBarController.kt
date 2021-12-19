package ch.keepcalm.demo.infrastructure.api

import kotlinx.coroutines.reactive.awaitSingle
import org.jmolecules.architecture.onion.classical.InfrastructureRing
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.MediaTypes
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@InfrastructureRing
@RestController
class FooBarController {

    @GetMapping("/foobar", produces = [MediaTypes.HAL_JSON_VALUE])
    suspend fun fooBar(): EntityModel<Unit> {
        return EntityModel.of(Unit, linkTo(methodOn(FooBarController::class.java).fooBar()).withSelfRel().toMono().awaitSingle())
            .add(linkTo(methodOn(IndexRootController::class.java).index()).withRel(IanaLinkRelations.PREV).toMono().awaitSingle())
    }
}
