#!/usr/bin/env bash

docker pull 17hao/my-app-be:latest

docker stop my-app-be

docker rm my-app-be

docker rmi "$(docker images -f "dangling=true" -q)"

docker run --name my-app-be --network host -it -d 17hao/my-app-be
