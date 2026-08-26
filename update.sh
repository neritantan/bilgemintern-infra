#!/bin/bash

docker stop jenkins

docker rm jenkins

docker images prune -f

git pull

docker-compose up -d --build 