package ch.keepcalm.demo.stereotype

/**
 * Represents a business exception. Business exceptions signal attempts to invalidly change business invariants.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@MustBeDocumented
annotation class BusinessException

