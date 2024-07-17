resource "google_cloudbuild_trigger" "service-account-trigger" {
  github {
    owner = var.github-owner
    name = var.platform-repo-name
    push {
      branch = "^${var.platform-main-branch}$"
    }
  }

  service_account = google_service_account.cloudbuild_service_account.id
  filename        = "cloudbuild.yaml"
  depends_on = [
    google_project_iam_member.act_as,
    google_project_iam_member.logs_writer
  ]
}
