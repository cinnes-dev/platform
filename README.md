# platform
## Stuff I use
- Quarkus
- Cloud Build (CI)
- GCR (container registry)
- Cloud Run (compute platform)
- Secret manager

## Deployment
Auto deployed on merge to master

## Adding a Secret
1. Add to terraform [here](https://github.com/cinnes-dev/platform/blob/master/terraform/secret-manager.tf)
2. `terraform apply`
3. Add value for property [here](https://console.cloud.google.com/security/secret-manager?referrer=search&project=cinnes-dev).