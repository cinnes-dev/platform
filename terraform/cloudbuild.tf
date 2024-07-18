resource "google_cloudbuild_trigger" "service-account-trigger" {
  name = "platform-deploy-trigger"
  github {
    owner = var.github-owner
    name = var.platform-repo-name
    push {
      branch = var.platform-main-branch
    }
  }

  service_account = google_service_account.cloudbuild_service_account.id
  filename        = "ci/deploy.yaml"
  depends_on = [
    google_project_iam_member.act_as,
    google_project_iam_member.logs_writer,
    google_project_iam_member.storage_admin,
    google_project_iam_member.artifact_registry_admin,
    google_project_iam_member.run_admin,
    google_project_iam_member.secret-viewer
  ]

  include_build_logs = "INCLUDE_BUILD_LOGS_WITH_STATUS"
}
