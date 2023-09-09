FROM openjdk:11
COPY build/libs/my-site-be.jar /opt
CMD ["java", "-jar", "/opt/my-site-be.jar"]
