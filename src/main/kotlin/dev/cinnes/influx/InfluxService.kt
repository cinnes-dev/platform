package dev.cinnes.influx

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.kotlin.InfluxDBClientKotlin
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory
import com.influxdb.client.write.Point
import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.UnitBasedMetric
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
class InfluxService {

    @Inject
    lateinit var influxConfig: InfluxConfig

    fun push(metrics: Set<BaseMetric>) = runBlocking {
        client().use { client ->
            metrics.forEach { metric ->
                pushMetric(client, metric)
            }
        }
    }

    fun push(metric: BaseMetric) = runBlocking {
        client().use {
            client -> pushMetric(client, metric)
        }
    }

    private suspend fun pushMetric(client: InfluxDBClientKotlin, metric: BaseMetric) {
        val points = metric.data.map { measurement ->
            val point = Point.measurement(metric.typeIdentifier())
                .addField("value", measurement.qty)
                .time(measurement.date, WritePrecision.NS)

            when (metric) {
                is UnitBasedMetric<*> ->
                    point.addTag("unit", metric.units.name)
            }

            point
        }

        client.getWriteKotlinApi().writePoints(points)
    }

    private fun client(): InfluxDBClientKotlin = InfluxDBClientKotlinFactory.create(influxConfig.clientOptions())
}