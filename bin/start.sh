#!/usr/bin/env bash

ROOT=$(pwd)

bash "${ROOT}"/gradlew clean bootJar

java -DLOGDIR="${ROOT}/log" -Dspring.profiles.active=prod -jar "${ROOT}"/build/libs/my-app-be.jar
