variable "project" {
  type = string
  default = "cinnes-dev"
}

variable "region" {
  type = string
  default = "europe-west2"
}

variable "region-us" {
  type = string
  default = "us-east1"
}

variable "gcr-location-us" {
  type = string
  default = "us"
}

variable "domain-name" {
  type = string
  default = "cinnes.dev"
}

variable "platform-main-branch" {
  type = string
  default = "master"
}

variable "github-owner" {
  type = string
  default = "cinnes-dev"
}

variable "platform-repo-name" {
  type = string
  default = "platform"
}
