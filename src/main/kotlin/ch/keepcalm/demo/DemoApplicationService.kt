package ch.keepcalm.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.support.WebStack
import org.springframework.web.server.adapter.ForwardedHeaderTransformer

@SpringBootApplication
@EnableHypermediaSupport(stacks = [WebStack.WEBFLUX], type = [EnableHypermediaSupport.HypermediaType.HAL])
class DemoApplicationService {

    @Bean
    fun forwardedHeaderTransformer(): ForwardedHeaderTransformer? {
        return ForwardedHeaderTransformer()
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplicationService>(*args)
}
