#!/bin/bash
set -e

# Helper script to set up Skaffold for local development.
# This clones the kernel-service-poc-config git repo,
# points it to the local version of this repo (rather than a published version),
# and points skaffold to the -config repo's kustomize.
# If you need to pull changes to the -config repo, just delete your local kernel-service-poc-config directory and rerun the script.

#Required input
NAMESPACE=$1

# For other services forking this TEMPLAET repo, change this line to the appropriate config repo. 
git clone https://github.com/DataBiosphere/kernel-service-poc-config

# Point skaffold to the new kustomize base
sed -i '' "s|NAMESPACE|${NAMESPACE}|g" skaffold.yaml

# Replace kernel-poc-service default config with the local changes
sed -i '' "s|github.com/databiosphere/kernel-service-poc//config?ref=0.0.0|../../../config|g" kernel-service-poc-config/${NAMESPACE}/kustomization.yaml

# That's it! You can now deploy to the k8s cluster by running
# skaffold run
# skaffold run --default-repo gcr.io/terra-kernel-k8s
