FROM maven:3.8.6-eclipse-temurin-17 as builder

WORKDIR /app

COPY mvnw pom.xml ./

COPY ./src ./src

RUN mvn clean install -Dskiptests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar"]