resource "google_storage_bucket" "cloudbuild_logs" {
  # Unique across all cloud storage users
  name     = "cinnes-dev-platform-cloudbuild-logs"
  location = "EU"
  force_destroy = true
  public_access_prevention = "enforced"
}

resource "google_storage_bucket" "build_cache" {
  # Unique across all cloud storage users
  name     = "cinnes-dev-build-cache"
  location = "EU"
  force_destroy = true
  public_access_prevention = "enforced"
}