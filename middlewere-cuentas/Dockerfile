# 1. Base image with JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Working directory inside the container
WORKDIR /app

# 3. Copy the compiled JAR from target to the container
COPY target/middlewere-cuentas-0.0.1-SNAPSHOT.war /app/middlewere-cuentas-0.0.1-SNAPSHOT.war

# 4. Expose the port where Spring Boot runs
EXPOSE 8080

# 6. Default command to run the application
CMD ["java", "-jar", "middlewere-cuentas-0.0.1-SNAPSHOT.war"]

