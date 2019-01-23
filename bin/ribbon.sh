#!/bin/bash
cd ../service-ribbon
mvn clean package -Dmaven.test.skip=true
docker build -t ribbon .
