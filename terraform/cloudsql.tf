resource "google_sql_database_instance" "main" {
  name = "platform-db"
  database_version = "POSTGRES_15"
  region = var.region

  # TODO: Set to true once terraform is stabilised
  deletion_protection = false

  settings {
    tier = "db-f1-micro"
  }
}

resource "google_sql_user" "users" {
  name     = "me"
  instance = google_sql_database_instance.main.name
  # TODO: ugh ye change this
  password = "changeme"
}