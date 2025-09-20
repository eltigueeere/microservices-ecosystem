# Mis proyectos

Este repo contiene 3 proyectos. Aquí algunos comandos útiles:

---
## 📦 
### 🔧 Comandos básicos DOCKER
10. ver si un puerto esta libre 
sudo lsof -i :8081
Ver contenedor
docker ps -a
1. Verificar el estado del servicio Docker
sudo systemctl status docker
2. Ver qué imágenes tienes en tu máquina local
docker images ls

Parar la imagen 
docker stop imagen
eliminar la img
docker rmi  --force ELID
del contenedor
docker rm  -f NAME

3. Construi img
# Construir la imagen y ponerle un tag
docker build -t middleware:1.0 .
correr sin parametros de contrasenas
docker run -d \
  --name my-ggo-cuentas \
  -p 8082:8082 \
  ggo-cuentas:1.0
OR
docker run -d --name my-ggo-cuentas --network mi-red -p 8082:8082 --env-file .env ggo-cuentas:1.0
correr con secre5ts
docker run -d --network mi-red --env-file .env -p 8081:8081 --name my-crud crud:1.0

entrar 
docker exec -it my-middleware bash

ver logs
docker logs -f my-middleware


##
##RED
##
# Crear red (si no existe)

docker network create mi-red
#relacionar contenedores en la misma red
docker run -d --name my-redis --network mi-red redis:7

# Correr MySQL en la red
docker run -d --name my-mysql --network mi-red -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=cuentasUsuariosdb mysql:8.0

# Correr Spring Boot en la misma red
docker run --network mi-red --env-file .env -p 8081:8081 --name my-crud my-crud:1.0


###
## 📦 Services 1: REDIS on docker
### 🔧 Comandos básicos
1. Descargar la imagen oficial de Redis (la más estable)
docker pull redis:7

2. Correr un contenedor de Redis
docker run -d \
  --name my-redis \
  -p 6379:6379 \
  redis:7

docker start my-redis


3. Ver configuración / detalles del contenedor

Ver puertos y estado:

docker ps


Inspeccionar info completa (incluye IP interna, binds, env, etc.):

docker inspect my-redis


Solo puertos:

docker port my-redis

4. Conectarse a Redis dentro del contenedor
docker exec -it my-redis redis-cli


Ahí puedes probar:

PING


Y te debe responder con:

PONG

## 📦 Services 1: MYSQL on docker

IMG MYSQL download
docker pull mysql:8.0

Crear e inicializar un contenedor de MySQL
docker run -d \
  --name my-mysql \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -e MYSQL_DATABASE=cuentasUsuariosdb \
  -e MYSQL_USER=user1 \
  -e MYSQL_PASSWORD=12345 \
  -p 3306:3306 \
  mysql:8.0

step  2
docker start my-mysql
4. Ver información del contenedor (puertos, IP, estado)
docker inspect my-mysql

Si solo quieres ver los puertos:

docker port my-mysql


Para obtener la IP interna del contenedor:

docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' my-mysql


5. Entrar dentro del contenedor MySQL
docker exec -it my-mysql bash


Y ya dentro, conectarte al cliente MySQL:

mysql -u root -p





##########OTROS
2️⃣ Detener el contenedor actual
docker stop my-crud
docker rm my-crud


stop detiene el contenedor en ejecución.

rm elimina el contenedor viejo para poder crear uno nuevo.

3️⃣ Volver a compilar tu aplicación
mvn clean package


Esto genera de nuevo tu .war actualizado con el nuevo puerto.

4️⃣ Crear la nueva imagen Docker
docker build -t crud:1.0 .


La imagen ahora incluirá el .war con server.port=8081.

5️⃣ Correr el contenedor
docker run --network mi-red --env-file .env -p 8081:8081 --name my-crud crud:1.0






#############
############
###########
# ---------------------------------------
# Docker Commands Reference for README
# ---------------------------------------

# -----------------------------
# 1️⃣ List all containers (running or stopped)
# -----------------------------
docker ps -a

# -----------------------------
# 2️⃣ Start a container interactively (with terminal)
# -----------------------------
docker run --network <NETWORK_NAME> --env-file .env -p 8081:8081 --name <CONTAINER_NAME> <IMAGE_NAME>

# -----------------------------
# 3️⃣ Start a container in detached mode (background)
# -----------------------------
docker run -d --network <NETWORK_NAME> --env-file .env -p 8081:8081 --name <CONTAINER_NAME> <IMAGE_NAME>

# -----------------------------
# 4️⃣ Stop a running container
# -----------------------------
docker stop <CONTAINER_NAME>

# -----------------------------
# 5️⃣ Remove a container
# -----------------------------
docker rm <CONTAINER_NAME>

# -----------------------------
# 6️⃣ Build a Docker image from Dockerfile
# -----------------------------
docker build -t <IMAGE_NAME>:<TAG> .

# -----------------------------
# 7️⃣ Copy JAR/WAR into container (done via Dockerfile)
# -----------------------------
# In Dockerfile:
COPY target/<JAR_WAR_FILE> /app/<JAR_WAR_FILE>

# -----------------------------
# 8️⃣ Expose a port from container to host (Dockerfile)
# -----------------------------
# In Dockerfile:
EXPOSE 8082

# -----------------------------
# 9️⃣ Execute a command inside a running container (interactive shell)
# -----------------------------
docker exec -it <CONTAINER_NAME> bash

# -----------------------------
# 10️⃣ Install MySQL client inside container (optional troubleshooting)
# -----------------------------
apt update && apt install -y mysql-client

# -----------------------------
# 11️⃣ Test MySQL connection from container
# -----------------------------
mysql -h <MYSQL_CONTAINER_NAME> -u<USERNAME> -p<PASSWORD> -D <DATABASE_NAME>

# -----------------------------
# 12️⃣ Ping another container from within a container (optional troubleshooting)
# -----------------------------
ping <OTHER_CONTAINER_NAME>

# -----------------------------
# 13️⃣ Create a custom Docker network
# -----------------------------
docker network create <NETWORK_NAME>

# -----------------------------
# 14️⃣ Run container with a specific port mapping different from internal port
# -----------------------------
docker run -d --name <CONTAINER_NAME> --network <NETWORK_NAME> -p 8082:8082 --env-file .env <IMAGE_NAME>

# -----------------------------
# 15️⃣ Environment variable placeholders in .env
# -----------------------------
# SPRING_DATASOURCE_URL=jdbc:mysql://<MYSQL_CONTAINER_NAME>:3306/<DB_NAME>
# SPRING_DATASOURCE_USERNAME=root
# SPRING_DATASOURCE_PASSWORD=1234
# SPRING_REDIS_URL=<REDIS_CONTAINER_NAME>
# SPRING_REDIS_PORT=6379


Replace <CONTAINER_NAME> with your actual container name (my-crud, my-ggo-cuentas, my-redis, etc.).

Replace <IMAGE_NAME> and <TAG> with the image you built (crud:1.0, ggo-cuentas:1.0).

<NETWORK_NAME> is your Docker network (e.g., mi-red).

## Pasos para ejecutar:

1. Parar contenedores actuales:
bash
docker stop my-ggo-cuentas my-crud my-middleware my-redis my-mysql


2. Eliminar contenedores:
bash
docker rm my-ggo-cuentas my-crud my-middleware my-redis my-mysql


3. Levantar con Docker Compose:
bash
docker-compose up -d


4. Configurar Redis (después de que levanten los servicios):
bash
./redis-init.sh


5. Verificar que todo esté funcionando:
bash
docker-compose ps



Ver logs de todos los contenedores:
bash
docker-compose logs


Ver logs en tiempo real (seguimiento):
bash
docker-compose logs -f


Ver logs de un servicio específico:
bash
docker-compose logs my-ggo-cuentas
docker-compose logs my-crud


Ver logs con timestamps:
bash
docker-compose logs -t


Ver solo las últimas N líneas:
bash
docker-compose logs --tail=50


Combinado (tiempo real + timestamps + últimas 100 líneas):
bash
docker-compose logs -f -t --tail=100



> ok todo esta perfecto Te amo, y ahora que tendria que hacer si solo quiero parar y levantar un contenedor en especifico eso lo puedo hacer con los comandos que ya se y no afecto nada en teorio solo paro el contendor compiolo de nuevo el projecto y creo la imagen y la corro ?

> ## Con Docker Compose es más fácil:

Parar un servicio específico:
bash
docker-compose stop my-ggo-cuentas


Levantar un servicio específico:
bash
docker-compose up -d my-ggo-cuentas


Reconstruir y levantar un servicio (después de compilar tu proyecto):
bash
docker-compose up -d --build my-ggo-cuentas


## Pero sí, también puedes usar los comandos tradicionales:

Método tradicional (como ya sabes):
bash
# 1. Parar y eliminar
docker stop my-ggo-cuentas
docker rm my-ggo-cuentas

# 2. Compilar proyecto
mvn clean package

# 3. Crear nueva imagen
docker build -t ggo-cuentas:1.0 .

# 4. Correr contenedor
docker run -d --name my-ggo-cuentas --network mi-red -p 8082:8082 --env-file .env ggo-cuentas:1.0
