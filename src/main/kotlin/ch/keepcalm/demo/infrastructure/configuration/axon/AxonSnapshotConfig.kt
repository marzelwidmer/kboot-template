package ch.keepcalm.demo.infrastructure.configuration.axon

import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition
import org.axonframework.eventsourcing.SnapshotTriggerDefinition
import org.axonframework.eventsourcing.Snapshotter
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class AxonSnapshotConfig(private val axonSnapshotThresholdConfigurer: AxonSnapshotThresholdConfigurer) {


    @Bean
    fun snapshotTriggerDefinition(snapshotter: Snapshotter?): SnapshotTriggerDefinition {
        return EventCountSnapshotTriggerDefinition(snapshotter, axonSnapshotThresholdConfigurer.snapshotThreshold)
    }
}
