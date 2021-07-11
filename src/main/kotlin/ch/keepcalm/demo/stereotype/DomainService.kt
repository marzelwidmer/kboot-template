package ch.keepcalm.demo.stereotype

/**
 * Represents a domain service implementing business logic not directly assignable to a specific aggregate. Domain
 * services may also provide domain event handlers.
 */
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class DomainService

