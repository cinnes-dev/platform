package dev.cinnes.health.model

enum class WeightUnit {
    kg,
    lbs
}

data class Weight(
    val units: WeightUnit,
    val data: Set<MetricReading>
): BaseMetric() {
    companion object {
        const val TYPE_IDENTIFIER: String = "weight_body_mass"
    }
}