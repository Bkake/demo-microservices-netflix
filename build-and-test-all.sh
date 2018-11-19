#!/usr/bin/env bash

echo "Building and testing all services....";

set -e

cd ./discovery-service; mvn clean package; cd -
cd ./zipkin-service; mvn clean package; cd -
cd ./category-service; mvn clean package; cd -
cd ./author-service; mvn clean package; cd -
cd ./new-service; mvn clean package; cd -
cd ./gateway-service; mvn clean package; cd -
cd ./hystrix-dashboard; mvn clean package; cd -
cd ./admin-dashboard; mvn clean package; cd -
cd ./config-service; mvn clean package; cd -
cd ./security-service; mvn clean package; cd -
find . -name *SNAPSHOT.jar -exec du -h {} \;
