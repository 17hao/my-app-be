#FROM gradle:6.9-jdk11 AS cache
#ENV GRADLE_USER_HOME /cache
#WORKDIR /gradle
#COPY build.gradle settings.gradle ./
#RUN gradle --no-daemon build --info
#
#FROM gradle:6.9-jdk11 AS builder
#COPY --from=cache /cache /home/gradle/.gradle
#WORKDIR /app
#COPY src/ src/
#COPY build.gradle settings.gradle ./
#RUN gradle --no-daemon springBoot --info
#
#FROM openjdk:11
#WORKDIR /app
#COPY --from=builder /app/build/libs/*.jar app.jar
#ENTRYPOINT ["java", "-DLOGDIR=/app", "-Dspring.profiles.active=prod", "-jar", "app.jar"]

FROM openjdk:11-jre-slim-buster
WORKDIR /app
COPY ./build/libs/my-app-be.jar app.jar
ENTRYPOINT ["java", "-DLOGDIR=/app", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
