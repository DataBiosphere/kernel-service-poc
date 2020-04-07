#!/bin/bash
set -e

# Helper script to set up Skaffold for local development.
# This clones the kernel-service-poc-config git repo,
# points it to the local version of this repo (rather than a published version),
# and points skaffold to the -config repo's kustomize.
# If you need to pull changes to the -config repo, just delete your local kernel-service-poc-config directory and rerun the script.

#Required input
NAMESPACE=$1

# For other services forking this TEMPLATE repo, change this line to the appropriate config repo. 
git clone https://github.com/DataBiosphere/terra-config

# Point skaffold to the new kustomize base
sed "s|NAMESPACE|${NAMESPACE}|g" skaffold.yaml.template > skaffold.yaml

# Replace kernel-poc-service default config with the local changes
sed -i '' "s|github.com/databiosphere/kernel-service-poc//config?ref=0.0.0|../../../../config|g" terra-config/${NAMESPACE}/kernel-service-poc/kustomization.yaml

# That's it! You can now deploy to the k8s cluster by running
# $ skaffold run
# Or by using IntelliJ's Cloud Code integration, which will auto-detect the generated skaffold.yaml file.
