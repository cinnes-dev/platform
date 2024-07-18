resource "google_service_account" "cloudbuild_service_account" {
  account_id = "cloud-sa"
  display_name = "SA for cloudbuild"
}

resource "google_project_iam_member" "act_as" {
  project = var.project
  role = "roles/iam.serviceAccountUser"
  member = "serviceAccount:${google_service_account.cloudbuild_service_account.email}"
}

resource "google_project_iam_member" "logs_writer" {
  project = var.project
  role    = "roles/logging.logWriter"
  member  = "serviceAccount:${google_service_account.cloudbuild_service_account.email}"
}

# limit access of all below
resource "google_project_iam_member" "storage_admin" {
  project = var.project

  role    = "roles/storage.admin"
  member  = "serviceAccount:${google_service_account.cloudbuild_service_account.email}"
}

resource "google_project_iam_member" "artifact_registry_admin" {
  project = var.project
  role    = "roles/artifactregistry.admin"
  member  = "serviceAccount:${google_service_account.cloudbuild_service_account.email}"
}

resource "google_project_iam_member" "run_admin" {
  project = var.project
  role    = "roles/run.admin"
  member  = "serviceAccount:${google_service_account.cloudbuild_service_account.email}"
}