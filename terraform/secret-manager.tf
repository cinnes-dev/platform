resource "google_secret_manager_secret" "secret_top_secret" {
  secret_id = "top-secret"
  project = var.project

  replication {
    user_managed {
      replicas {
        location = var.region
      }
    }
  }
}