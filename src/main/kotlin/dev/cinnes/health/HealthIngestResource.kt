package dev.cinnes.health

import dev.cinnes.influx.InfluxService
import dev.cinnes.health.HealthIngest.API_KEY_HEADER
import dev.cinnes.health.model.request.HealthIngestRequest
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.HeaderParam
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.jboss.logging.Logger

object HealthIngest {
    const val API_KEY_HEADER = "x-api-key"
}

@Path("/health/ingest")
class HealthIngestResource {

    @ConfigProperty(name = "health.ingest.key")
    lateinit var apiKey: String

    @Inject
    lateinit var influxService: InfluxService

    private val log: Logger = Logger.getLogger(this.javaClass.name);

    @POST
    @Consumes(APPLICATION_JSON)
    fun ingest(@HeaderParam(API_KEY_HEADER) key: String, request: HealthIngestRequest) {
        if (apiKey != key) return

        val receivedMetricTypes = request.data.metrics.map { metric -> metric.javaClass.simpleName }
        log.info("Received health ingest with metrics: $receivedMetricTypes")

        influxService.push(request.data.metrics)
    }
}