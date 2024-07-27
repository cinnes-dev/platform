package dev.cinnes.health.model

abstract class UnitBasedMetric<T: Enum<T>>(
    open val units: T,
    override val data: Set<MetricReading>
): BaseMetric(data)