package dev.cinnes.influx

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.kotlin.InfluxDBClientKotlin
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory
import com.influxdb.client.write.Point
import dev.cinnes.health.model.BaseMetric
import dev.cinnes.health.model.Weight
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
class InfluxService {

    @Inject
    lateinit var influxConfig: InfluxConfig

    fun push(metric: BaseMetric) = runBlocking {
        client().use { client ->
            val points = metric.data.map { measurement ->

                val actualValue = when (metric) {
                    // convert to lbs
                    // TODO: do this in a cleaner way...
                    is Weight -> measurement.qty * 2.20462
                    else -> measurement.qty
                }

                Point.measurement(metric.typeIdentifier())
                    .addField("value", actualValue)
                    .time(measurement.date, WritePrecision.NS)
            }

            client.getWriteKotlinApi().writePoints(points)
        }
    }

    private fun client(): InfluxDBClientKotlin = InfluxDBClientKotlinFactory.create(influxConfig.clientOptions())
}