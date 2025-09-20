# 1. Imagen base con JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el JAR compilado del target al contenedor
COPY target/microservice-ggo-cuentas-0.0.1-SNAPSHOT.war /app/microservice-ggo-cuentas-0.0.1-SNAPSHOT.war

# 4. Exponer el puerto en el que corre tu Spring Boot
EXPOSE 8082

# 5. Comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "microservice-ggo-cuentas-0.0.1-SNAPSHOT.war"]
