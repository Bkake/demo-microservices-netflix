#!/usr/bin/env bash

echo "Cleaning all services...";

set -e

cd ./discovery-service; mvn clean; cd -
cd ./zipkin-service; mvn clean; cd -
cd ./category-service; mvn clean; cd -
cd ./author-service; mvn clean; cd -
cd ./new-service; mvn clean; cd -
cd ./gateway-service; mvn clean; cd -
cd ./hystrix-dashboard; mvn clean; cd -
cd ./admin-dashboard; mvn clean; cd -