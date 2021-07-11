package ch.keepcalm.demo.stereotype

import org.springframework.stereotype.Component

/**
 * Represents an application service responsible for providing access to the domain to external clients. An application
 * service orchestrates use cases, but does not contain business logic.
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class ApplicationService

