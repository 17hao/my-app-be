#!/usr/bin/env bash

ROOT=$(pwd)

bash "${ROOT}"/mvnw install spring-boot:repackage

docker stop my-app-be

docker rm my-app-be

docker rmi 17hao/my-app-be

https_proxy=127.0.0.1:8889 docker build -t 17hao/my-app-be:latest "${ROOT}"
