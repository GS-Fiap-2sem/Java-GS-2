
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*-runner.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar","-Dquarkus.http.host=0.0.0.0"]
