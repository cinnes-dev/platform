package dev.cinnes

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/secrets")
class SecretExposingResource {

    @Inject
    @field: Default
    lateinit var secretManager: GCPSecretManager

    @GET
    @Path("/{secretName}")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@PathParam("secretName") secretName: String): String = secretManager.getSecret(secretName)
}
