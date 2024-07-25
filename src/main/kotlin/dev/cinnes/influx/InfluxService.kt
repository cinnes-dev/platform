package dev.cinnes.influx

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.kotlin.InfluxDBClientKotlin
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory
import com.influxdb.client.write.Point
import dev.cinnes.health.model.Weight
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
class InfluxService {

    @Inject
    lateinit var influxConfig: InfluxConfig

    fun push(weight: Weight) = runBlocking {
        client().use { client ->

            val points = weight.data.map { measurement ->
                Point.measurement(Weight.TYPE_IDENTIFIER)
                    .addField("value", measurement.qty * 2.20462) // convert to lbs
                    .time(measurement.date, WritePrecision.NS)
            }

            client.getWriteKotlinApi().writePoints(points)
        }
    }

    private fun client(): InfluxDBClientKotlin = InfluxDBClientKotlinFactory.create(influxConfig.clientOptions())
}