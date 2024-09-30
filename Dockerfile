FROM openjdk:21
EXPOSE 8081
COPY target/Demo.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]