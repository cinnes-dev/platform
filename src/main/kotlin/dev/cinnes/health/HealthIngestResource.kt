package dev.cinnes.health

import com.google.cloud.storage.Storage
import dev.cinnes.health.HealthIngest.API_KEY_HEADER
import dev.cinnes.health.model.AbstractData
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
    lateinit var storage: Storage

    private val log: Logger = Logger.getLogger(this.javaClass.name);

    @POST
    @Consumes(APPLICATION_JSON)
    fun ingest(@HeaderParam(API_KEY_HEADER) key: String, request: HealthIngestRequest): Unit {
        if (apiKey != key) return

        request.data.metrics.forEach(log::info)

        log.info("Received health ingest")
    }

    data class HealthIngestRequest(val data: HealthIngestData)
    data class HealthIngestData(val metrics: Set<AbstractData>)
}