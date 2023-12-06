# Build stage
FROM maven:3.8.4-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

# Final stage
FROM openjdk:8
WORKDIR /app
COPY --from=build /app/target/health-0.0.1-SNAPSHOT.jar /app/health.jar
EXPOSE 8081
CMD ["java", "-jar", "health.jar"]
