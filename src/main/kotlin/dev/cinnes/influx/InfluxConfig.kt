package dev.cinnes.influx

import com.influxdb.client.InfluxDBClientOptions
import io.smallrye.config.ConfigMapping

@ConfigMapping(prefix = "influx")
interface InfluxConfig {
    fun url(): String
    fun token(): String
    fun org(): String
    fun bucket(): String


    fun clientOptions(): InfluxDBClientOptions =
        InfluxDBClientOptions.builder()
            .url(url())
            .authenticateToken(token().toCharArray())
            .org(org())
            .bucket(bucket())
            .build()
}