FROM openjdk:11-jre-slim-buster
WORKDIR /app
COPY ./my-app-be-application/target/my-app-be-application.jar app.jar
ENTRYPOINT ["java", "-DLOGDIR=/app", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
