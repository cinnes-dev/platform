package dev.cinnes.health.model.exercise

import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.MetricReading

data class FlightsClimbed(
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "flights_climbed"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}