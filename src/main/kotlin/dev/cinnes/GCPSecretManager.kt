package dev.cinnes

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient
import com.google.cloud.secretmanager.v1.SecretVersionName
import jakarta.enterprise.context.RequestScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import org.eclipse.microprofile.config.inject.ConfigProperty

@RequestScoped
class GCPSecretManager {

    @Inject
    @field: Default
    lateinit var client: SecretManagerServiceClient

    @field: ConfigProperty(name = "quarkus.google.cloud.project-id")
    lateinit var projectId: String

    fun getSecret(secretName: String): String {
        val secretVersionName: SecretVersionName = SecretVersionName.of(projectId, secretName, "latest")
        val response: AccessSecretVersionResponse = client.accessSecretVersion(secretVersionName)
        return response.payload.data.toStringUtf8()
    }
}