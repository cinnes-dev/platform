resource "google_cloud_run_v2_service" "platform" {
  name     = "platform"
  location = "us-central1"
  project  = var.project

  template {
    service_account = google_service_account.cloudbuild_service_account.email

    containers {
      image = data.google_artifact_registry_docker_image.myimage.self_link

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