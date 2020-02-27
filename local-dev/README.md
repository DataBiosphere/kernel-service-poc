This directory contains scripts for running continuous development builds. This is not necessary for deployment, but it can be helpful for developing faster.
To use this, first ensure Skaffold is installed on your local machine (available at https://skaffold.dev/). Next, provide GCP credentials as a Docker helper with `gcloud auth configure-docker`. Finally, run local-run.sh with your target environment as the first argument:

```
./local-run.sh <environment>
```

Skaffold will run continuously, building and deploying your new image to the specified namespace on the terra-kernel-k8s cluster.
