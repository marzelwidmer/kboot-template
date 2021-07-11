package ch.keepcalm.demo.stereotype

import org.springframework.stereotype.Component

/**
 * Represents an infrastructure service. An infrastructure service provides functionality to the domain that requires
 * additional infrastructure only available outside of the domain. The infrastructure service interface forms part of
 * the domain, the implementation is part of the infrastructure.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class InfrastructureService

