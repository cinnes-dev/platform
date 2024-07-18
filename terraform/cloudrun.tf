resource "google_cloud_run_v2_service" "platform" {
  name     = "platform"
  location = "us-central1"
  project  = var.project

  template {
    containers {
      image = "us-docker.pkg.dev/cloudrun/container/hello"

      resources {
        limits = {
          cpu = "1"
          memory = "512Mi"
        }
      }
    }
    service_account = google_service_account.cloudbuild_service_account.email
  }
}