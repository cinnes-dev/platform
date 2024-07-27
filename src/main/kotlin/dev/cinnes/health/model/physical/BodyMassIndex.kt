package dev.cinnes.health.model.physical

import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.MetricReading

data class BodyMassIndex(
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "body_mass_index"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}