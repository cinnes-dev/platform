resource "google_cloud_run_v2_service" "platform_service" {
  name     = "platform"
  location = var.region-us
  project  = var.project

  template {
    service_account = google_service_account.cloudbuild_sa.email

    containers {
      image = data.google_artifact_registry_docker_image.platform_image.self_link

      resources {
        limits = {
          cpu = "1"
          memory = "512Mi"
        }
      }
    }

    annotations = {
      # https://cloud.google.com/sdk/gcloud/reference/run/deploy#--ingress
      "run.googleapis.com/ingress" = "all"
    }
  }

  depends_on = [
    google_artifact_registry_repository.platform
  ]
}

resource "google_cloud_run_domain_mapping" "default" {
  location = var.region-us
  name     = var.domain-name

  spec {
    route_name = google_cloud_run_v2_service.platform_service.name
  }

  metadata {
    namespace = var.project
  }
}