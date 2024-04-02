#!/bin/bash

# eval $(minikube docker-env)
# Jib google docker build with minikube
./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=reservation-service:v0.1.0-alpha

# Build deployment and service
kubectl apply -f ./k8s