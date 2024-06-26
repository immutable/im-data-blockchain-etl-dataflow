terraform {
  required_version = ">=0.13"

  backend "gcs" {
    bucket = "im-common-cicd-infra"
    prefix = "terraform/state/im-data-blockchain-etl-dataflow"
  }

  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "~> 4.82.0, < 5.0.0"
    }
    google-beta = {
      source  = "hashicorp/google-beta"
      version = ">= 4.82.0, < 5.0.0"
    }
  }
  provider_meta "google" {
    module_name = "blueprints/terraform/exported-krm/v0.1.0"
  }
}