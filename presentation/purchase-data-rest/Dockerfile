FROM eclipse-temurin:21 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN apt-get update && apt-get install -y maven
RUN mvn clean install 

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/purchase-data-rest-*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]