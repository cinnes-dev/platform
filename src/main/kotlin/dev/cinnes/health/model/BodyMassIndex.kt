package dev.cinnes.health.model

data class BodyMassIndex(
    override val data: Set<MetricReading>
): BaseMetric(data) {
    companion object {
        const val TYPE_IDENTIFIER: String = "body_mass_index"
    }

    override fun typeIdentifier(): String = TYPE_IDENTIFIER
}