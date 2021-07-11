package ch.keepcalm.demo.stereotype

/**
 * Represents a repository for aggregates. A repository is responsible for accepting aggregates of a specific type,
 * keeping them and returning the as requested by the domain. The repository interface forms part of the domain, the
 * implementation (e.g. against a database) is part of the infrastructure.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Repository

