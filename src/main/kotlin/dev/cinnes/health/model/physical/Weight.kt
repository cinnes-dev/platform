package dev.cinnes.health.model.physical

import dev.cinnes.health.model.MetricReading
import dev.cinnes.health.model.UnitBasedMetric
import dev.cinnes.health.model.units.WeightUnit

data class Weight(
    override val units: WeightUnit,
    override val data: Set<MetricReading>
): UnitBasedMetric<WeightUnit>(units, data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "weight_body_mass"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}