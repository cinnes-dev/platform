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

resource "google_secret_manager_secret" "sentry-auth-token" {
  secret_id = "sentry-auth-token"
  project = var.project

  replication {
    user_managed {
      replicas {
        location = var.region
      }
    }
  }
}

resource "google_secret_manager_secret" "influx-token" {
  secret_id = "influx-token"
  project = var.project

  replication {
    user_managed {
      replicas {
        location = var.region
      }
    }
  }
}
