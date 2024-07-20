variable "project" {
  type = string
  default = "cinnes-dev"
}

variable "region" {
  type = string
  default = "europe-west1"
}

variable "region-us" {
  type = string
  default = "us-east1"
}

variable "gcr-region-us" {
  type = string
  default = "us"
}

variable "zone" {
  type = string
  default = "europe-west2-a"
}

variable "domain-name" {
  type = string
  default = "cinnes.dev"
}

variable "platform-main-branch" {
  type = string
  default = "master"
}

variable "platform-repo" {
  type = string
  default = "cinnes-dev/platform"
}

variable "github-owner" {
  type = string
  default = "cinnes-dev"
}

variable "platform-repo-name" {
  type = string
  default = "platform"
}

variable "ssl" {
  type = bool
  default = false
}