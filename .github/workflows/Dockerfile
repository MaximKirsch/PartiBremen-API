FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

COPY . .

RUN chmod +x ./mvn
RUN ./mvn clean install

# --- run ---

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app/


COPY --from=builder /target/*.jae app.jar

EXPOSE 5000

ENTRYPOINT ["java","-jar","/app.jar"]