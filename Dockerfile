# ===========================
# Steg 1 - Bygg applikationen
# ===========================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Kopiera pom.xml först för att kunna cache:a dependencies
COPY pom.xml .

RUN mvn dependency:go-offline

# Kopiera resten av projektet
COPY src ./src

# Bygg projektet
RUN mvn clean package -DskipTests


# ===========================
# Steg 2 - Kör applikationen
# ===========================
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]