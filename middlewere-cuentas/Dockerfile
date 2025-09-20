# 1. Imagen base con JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el JAR compilado del target al contenedor
COPY target/middlewere-cuentas-0.0.1-SNAPSHOT.war /app/middlewere-cuentas-0.0.1-SNAPSHOT.war

# 4. Exponer el puerto en el que corre tu Spring Boot
EXPOSE 8080

# 6. Comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "middlewere-cuentas-0.0.1-SNAPSHOT.war"]

