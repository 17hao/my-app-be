FROM openjdk:11
RUN mkdir -p /opt/my-app-be
COPY ./build/libs/my-app-be.jar /opt/my-app-be
CMD ["java", "-DLOGDIR=/opt/my-app-be", "-jar", "/opt/my-app-be/my-app-be.jar"]
