package dev.cinnes.health.model.nutrition

import dev.cinnes.health.model.MetricReading
import dev.cinnes.health.model.UnitBasedMetric
import dev.cinnes.health.model.units.WeightUnit

data class PolyunsaturatedFat(
    override val units: WeightUnit,
    override val data: Set<MetricReading>
): UnitBasedMetric<WeightUnit>(units, data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "polyunsaturated_fat"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}