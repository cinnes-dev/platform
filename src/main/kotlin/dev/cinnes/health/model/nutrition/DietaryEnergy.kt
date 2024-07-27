package dev.cinnes.health.model.nutrition

import dev.cinnes.health.model.units.EnergyUnit
import dev.cinnes.health.model.MetricReading
import dev.cinnes.health.model.UnitBasedMetric

data class DietaryEnergy(
    override val units: EnergyUnit,
    override val data: Set<MetricReading>
): UnitBasedMetric<EnergyUnit>(units, data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "dietary_energy"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}