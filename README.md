# Description
CoreUI React.js + Spring boot

## Docker
### Build
mvn clean package docker:build

### Pull
docker pull r3kdotio/springbootangular-starter

## Run
docker run -p 8080:8080 r3kdotio/springbootangular-starter

## Kubernetes
kubectl create -f springbootangular-starter-deployment.yaml
kubectl expose deployment springbootreactjs-starter-deployment


