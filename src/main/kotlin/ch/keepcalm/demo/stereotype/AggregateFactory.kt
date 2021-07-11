package ch.keepcalm.demo.stereotype

import org.springframework.stereotype.Component
import kotlin.reflect.KClass

/**
 * Represents a factory responsible for creating new aggregate instances. An aggregate factory encapsulates the
 * knowledge required to create a new aggregate instance. An aggregate factory can either be a static method on an
 * aggregate, or a separate class, depending on the complexity of the instantiation process and the dependencies needed.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class AggregateFactory(val kClass: KClass<*>)

