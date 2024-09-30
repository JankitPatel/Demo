FROM openjdk:21
EXPOSE 8080
COPY target/Demo.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]