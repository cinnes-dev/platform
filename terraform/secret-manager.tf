resource "google_secret_manager_secret" "secret-basic" {
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