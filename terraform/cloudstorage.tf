resource "google_storage_bucket" "cloudbuild_logs" {
  name     = "cinnes-dev-platform-cloudbuild-logs"
  location = "EU"
  force_destroy = true
  public_access_prevention = "enforced"
}