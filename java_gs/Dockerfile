FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*-runner.jar app.jar

EXPOSE 8080

CMD ["java", "-Dquarkus.http.host=0.0.0.0", "-Dquarkus.http.port=8080", "-jar", "app.jar"]
