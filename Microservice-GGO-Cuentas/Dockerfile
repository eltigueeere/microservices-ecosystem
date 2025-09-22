# 1. Base image with JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Working directory inside the container
WORKDIR /app

# 3. Copy the compiled JAR from target to the container
COPY target/microservice-ggo-cuentas-0.0.1-SNAPSHOT.war /app/microservice-ggo-cuentas-0.0.1-SNAPSHOT.war

# 4. Expose the port where Spring Boot runs
EXPOSE 8082

# 5. Default command to run the application
CMD ["java", "-jar", "microservice-ggo-cuentas-0.0.1-SNAPSHOT.war"]
