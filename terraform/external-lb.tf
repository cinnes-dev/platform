module "lb-http" {
  source  = "terraform-google-modules/lb-http/google//modules/serverless_negs"
  version = "~> 10.0"

  name    = "cinnes-dev-external-lb"
  project = var.project

  ssl                             = var.ssl
#   managed_ssl_certificate_domains = [var.domain]
  https_redirect                  = var.ssl

  backends = {
    default = {
      description = null
      groups = [
        {
          group = google_compute_region_network_endpoint_group.serverless_neg.id
        }
      ]
      enable_cdn = false

      iap_config = {
        enable = false
      }
      log_config = {
        enable = false
      }
    }
  }

  depends_on = [
    google_compute_managed_ssl_certificate.default
  ]
}

resource "google_compute_region_network_endpoint_group" "serverless_neg" {
  provider              = google-beta
  name                  = "serverless-neg"
  network_endpoint_type = "SERVERLESS"
  region                = var.region
  project = var.project
  cloud_run {
    service = google_cloud_run_v2_service.platform.name
  }
}

resource "google_cloud_run_service_iam_member" "public-access" {
  location = google_cloud_run_v2_service.platform.location
  project  = google_cloud_run_v2_service.platform.project
  service  = google_cloud_run_v2_service.platform.name
  role     = "roles/run.invoker"
  member   = "allUsers"
}

resource "google_compute_managed_ssl_certificate" "default" {
  name = "cinnes-dev-cert"

  managed {
    domains = ["cinnes.dev"]
  }
}