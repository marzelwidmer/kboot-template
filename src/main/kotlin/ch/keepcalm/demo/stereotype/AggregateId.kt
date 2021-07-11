package ch.keepcalm.demo.stereotype

/**
 * Represents the aggregate id of an aggregate instance. Each aggregate contains one single annotated accessor method
 * providing access to the aggregate id.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class AggregateId

