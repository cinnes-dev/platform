package dev.cinnes.health

import dev.cinnes.health.HealthIngest.API_KEY_HEADER
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

    private val log: Logger = Logger.getLogger(this.javaClass.name);

    @POST
    @Consumes(APPLICATION_JSON)
    fun ingest(@HeaderParam(API_KEY_HEADER) key: String, body: String): Unit {
        if (apiKey != key) return

        log.info("Received health ingest")
    }
}