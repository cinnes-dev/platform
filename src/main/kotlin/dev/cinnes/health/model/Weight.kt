package dev.cinnes.health.model

import java.time.Instant

enum class WeightUnit {
    kg,
    lb
}

data class WeightRecording(val date: Instant, val qty: Float)
class Weight(val units: WeightUnit, val data: Set<WeightRecording>): AbstractData(DataType.weight_body_mass)
