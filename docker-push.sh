#!/usr/bin/env bash

#Push
docker login
docker push bkake/gateway-service;
docker push bkake/category-service;
docker push bkake/new-service;
docker push bkake/admin-dashboard;
docker push bkake/hystrix-dashboard;
docker push bkake/zipkin-service;
docker push bkake/discovery-service;
docker push bkake/config-service;
