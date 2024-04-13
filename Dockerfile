FROM maven:3.8.3-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# --- run ---
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app/


COPY --from=build /app/target/partibremen*.jar .

CMD ["java", "-jar", "*.jar"]