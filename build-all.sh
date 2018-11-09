#!/usr/bin/env bash

echo "Building all services....";

set -e

cd ./discovery-service; mvn clean package -DskipTests; cd -
cd ./zipkin-service; mvn clean package -DskipTests; cd -
cd ./category-service; mvn clean package -DskipTests; cd -
cd ./author-service; mvn clean package -DskipTests; cd -
cd ./new-service; mvn clean package -DskipTests; cd -
cd ./gateway-service; mvn clean package -DskipTests; cd -
cd ./hystrix-dashboard; mvn clean package -DskipTests; cd -
cd ./admin-dashboard; mvn clean package -DskipTests; cd -
cd ./config-service; mvn clean package -DskipTests; cd -
find . -name *SNAPSHOT.jar -exec du -h {} \;
