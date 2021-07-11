package ch.keepcalm.demo.stereotype

/**
 * Represents a value object. Value objects are immutable. Equality between two value object instances is defined by
 * their type and their internal state.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@MustBeDocumented
annotation class ValueObject
