FROM openjdk:17-jdk
COPY target/userservice.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "userservice.jar"]