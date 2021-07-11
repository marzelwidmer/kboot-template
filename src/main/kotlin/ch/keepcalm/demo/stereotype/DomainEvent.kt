package ch.keepcalm.demo.stereotype

/**
 * Represents an event relevant to the business domain. A domain event describes a fact that has happened in the past.
 * Domain events are immutable and carry the state relevant for consumers to understand the semantics of the domain
 * event.
 *
 * Type of the domain event. Must be defined for cross-bounded context domain events, but are is not mandatory for
 * intra-bounded context domain events. If defined, the type must be unique within the whole system. If not defined,
 * the type of the domain event is derived from the domain event class.
 */

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class DomainEvent

