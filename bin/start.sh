#!/usr/bin/env bash

ROOT=$(pwd)

if [ -d "${ROOT}"/build/libs ]; then
  rm -rf "${ROOT}"/build
fi

bash "${ROOT}"/gradlew build

java -jar "${ROOT}"/build/libs/my-site-be.jar
