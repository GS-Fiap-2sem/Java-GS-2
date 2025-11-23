FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*-runner.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dquarkus.http.host=0.0.0.0","-jar","app.jar"]
