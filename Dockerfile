FROM openjdk:11
COPY build/libs/web-app-backend.jar /opt
CMD ["java", "-jar", "/opt/web-app-backend.jar"]
