package dev.cinnes.health.model.nutrition

import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.units.EnergyUnit
import dev.cinnes.health.model.MetricReading

data class DietaryEnergy(
    val units: EnergyUnit,
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "dietary_energy"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}