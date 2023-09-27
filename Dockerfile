FROM openjdk:11
RUN mkdir -p /opt/my-site-be
COPY ./build/libs/my-site-be.jar /opt/my-site-be
CMD ["java", "-DLOGDIR=/opt/my-site-be", "-jar", "/opt/my-site-be/my-site-be.jar"]
