package dev.cinnes.health.model.nutrition

import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.MetricReading
import dev.cinnes.health.model.units.WeightUnit

data class Potassium(
    val units: WeightUnit,
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "potassium"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}