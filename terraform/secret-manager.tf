resource "google_secret_manager_secret" "health-ingest-key" {
  secret_id = "health-ingest-key"
  project = var.project

  replication {
    user_managed {
      replicas {
        location = var.region
      }
    }
  }
}