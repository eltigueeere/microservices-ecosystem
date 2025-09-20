# 1. Imagen base con JDK 21
FROM eclipse-temurin:21-jdk-jammy

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el JAR compilado del target al contenedor
COPY target/crud-cuentas-0.0.1-SNAPSHOT.war /app/crud-cuentas-0.0.1-SNAPSHOT.war

# 4. Exponer el puerto en el que corre tu Spring Boot
EXPOSE 8081

# 5. Variables de entorno para la conexión a MySQL (opcional si quieres reemplazar application.properties)
# ENV SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.2:3306/cuentasUsuariosdb
# ENV SPRING_DATASOURCE_USERNAME=root
# ENV SPRING_DATASOURCE_PASSWORD=1234

# 6. Comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "crud-cuentas-0.0.1-SNAPSHOT.war"]
