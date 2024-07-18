resource "google_cloud_run_service" "platform" {
  name     = "platform"
  location = "us-central1"
  project  = var.project

  template {
    spec {
      containers {
        image = "us-docker.pkg.dev/cloudrun/container/hello"
      }
    }
  }
}