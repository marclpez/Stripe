# Stage 1: Build
FROM maven:3.9.3-eclipse-temurin-21 AS build
WORKDIR /app
  
  # Copy pom.xml and dependencies for cache
COPY pom.xml .
RUN mvn dependency:go-offline
  
  # Build JAR
COPY src ./src
RUN mvn clean package -DskipTests
  
  # Stage 2: Run
FROM maven:3.9.3-jdk-21 AS build
WORKDIR /app
  
  # Copy JAR 
COPY --from=build /app/target/stripe-springboot-app-1.0.0.jar app.jar
  
  # Exponer el puerto que usa tu app
EXPOSE 8080
  
  # Comando por defecto
ENTRYPOINT ["java","-jar","/app/app.jar"]
