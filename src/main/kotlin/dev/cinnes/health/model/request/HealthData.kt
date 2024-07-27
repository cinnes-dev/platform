package dev.cinnes.health.model.request

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import dev.cinnes.health.model.BaseMetric

data class HealthData(
    @JsonSetter(contentNulls = Nulls.SKIP)
    val metrics: Set<BaseMetric>
)