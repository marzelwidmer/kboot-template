package ch.keepcalm.demo.infrastructure.configuration.axon

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * Configures a snapshot trigger to create a Snapshot every 500 events.
 * 500 is an arbitrary number used only for testing purposes just to show how the snapshots are stored on Mongo as well.
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "axon.aggregate")
data class AxonSnapshotThresholdConfigurer(var snapshotThreshold: Int = 500)
