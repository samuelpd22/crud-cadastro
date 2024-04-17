# Estágio de construção
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn package

# Estágio de execução
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/Advocacia.jar app.jar
CMD ["java", "-jar", "app.jar"]

LABEL authors="Rogerio"
