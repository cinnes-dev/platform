package dev.cinnes.health

import io.quarkus.security.identity.SecurityIdentity
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import org.jboss.logging.Logger

@Path("/health/ingest")
class HealthIngestResource {

    val log: Logger = Logger.getLogger(this.javaClass.name);

    @Inject
    lateinit var identity: SecurityIdentity

    @POST
    @Consumes(APPLICATION_JSON)
    fun ingest(body: String): Unit = log.info(identity.roles)

}