# 1. Base image with JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Working directory inside the container
WORKDIR /app

# 3. Copy the compiled JAR from target to the container
COPY target/crud-cuentas-0.0.1-SNAPSHOT.war /app/crud-cuentas-0.0.1-SNAPSHOT.war

# 4. Expose the port where Spring Boot runs
EXPOSE 8081

# 5. Environment variables for MySQL connection (optional if you want to replace application.properties)
# ENV SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.2:3306/cuentasUsuariosdb
# ENV SPRING_DATASOURCE_USERNAME=root
# ENV SPRING_DATASOURCE_PASSWORD=1234

# 6. Default command to run the application
CMD ["java", "-jar", "crud-cuentas-0.0.1-SNAPSHOT.war"]
