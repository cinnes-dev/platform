resource "google_secret_manager_secret" "secret-basic" {
  secret_id = "top-secret"

  replication {
    user_managed {
      replicas {
        location = var.secret-manager-location
      }
    }
  }
}