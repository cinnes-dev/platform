package dev.cinnes.health.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class MetricReading(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z")
    val date: Instant,
    val qty: Double)