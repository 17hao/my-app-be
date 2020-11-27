#!/usr/bin/env bash

ROOT=`pwd`

#exec ${ROOT}/gradlew build

JAR_PATH=${ROOT}/build/libs/springboot.jar
JVM_ARGUMENTS="-server -XX:+UseG1GC -Xmx512M"
nohup java -jar $JAR_PATH $JVM_ARGUMENTS &