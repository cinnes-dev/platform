package dev.cinnes.health.model

enum class WeightUnit {
    kg,
    lbs
}

data class Weight(
    val units: WeightUnit,
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "weight_body_mass"
    }

    override fun typeIdentifier(): String = BodyMassIndex.TYPE_IDENTIFIER
}