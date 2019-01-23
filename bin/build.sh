#!/bin/bash

cd ..
mvn clean package -Dmaven.test.skip=true
cd eureka-server
docker build -t eureka-server .
cd ../eureka-client
docker build -t eureka-client .
cd ../service-ribbon
docker build -t ribbon .
cd ../service-feign
docker build -t feign .