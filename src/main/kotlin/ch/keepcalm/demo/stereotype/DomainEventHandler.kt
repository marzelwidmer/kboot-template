package ch.keepcalm.demo.stereotype

/**
 * Represents a handler of a domain event. A domain event handler consumes domain events of a specific type. Domain
 * event handlers are responsible for dealing with receiving the same domain event multiple times (at-least-once
 * semantics).
 * <p>
 * Domain event handlers are typically part of domain services. A domain event handler method must accept a single
 * parameter of the domain event type handled.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class DomainEventHandler

