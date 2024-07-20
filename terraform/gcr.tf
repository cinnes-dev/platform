resource "google_artifact_registry_repository" "platform" {
  location      = var.gcr-region-us
  repository_id = "gcr.io"
  description   = "Contains deployment immages for cinnes-dev/platform"
  format        = "DOCKER"

  docker_config {
    immutable_tags = true
  }

  cleanup_policies {
    id = "keep-max"
    action = "KEEP"
    most_recent_versions {
      keep_count = 3
    }
  }
}

data "google_artifact_registry_docker_image" "myimage" {
  location      = google_artifact_registry_repository.platform.location
  repository_id = google_artifact_registry_repository.platform.repository_id
  image_name = var.platform-repo-name
}