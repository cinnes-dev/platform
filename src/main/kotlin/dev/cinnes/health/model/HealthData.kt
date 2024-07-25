package dev.cinnes.health.model

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls

data class HealthData(
    @JsonSetter(contentNulls = Nulls.SKIP)
    val metrics: Set<BaseMetric>
)