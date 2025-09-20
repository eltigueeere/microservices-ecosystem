# 🚀 Microservices Docker Setup

This repository contains 3 Spring Boot microservices, Redis, and MySQL, orchestrated via Docker Compose. This README provides an **organized, professional guide** for developers and CTOs.

---

## 📦 Architecture Overview

* **Database:** `MySQL 8.0` → used by `crud-cuentas`.
* **Cache:** `Redis 7` → used by `ggo-cuentas` for security keys.
* **Microservices:**

  * `crud-cuentas` → CRUD operations, depends on MySQL.
  * `middleware-cuentas` → Business logic layer, consumes `crud-cuentas`.
  * `ggo-cuentas` → Main microservice, depends on Redis and consumes HTTP`crud-cuentas` + `middleware-cuentas`.

**Network:** All containers communicate through `mi-red` Docker bridge network.
**Persistent storage:** MySQL data persists across restarts via `mysql_data` volume.

---

## ⚡ Docker Compose

### Start all services:

```bash
docker-compose up -d
```

### Stop all services:

```bash
docker-compose down
```

### Stop/start a single service:

```bash
docker-compose stop my-ggo-cuentas
docker-compose up -d my-ggo-cuentas
```

### Rebuild & restart a single service:

```bash
docker-compose up -d --build my-ggo-cuentas
```

### Check status of all containers:

```bash
docker-compose ps
```

### View logs:

* All services (real-time + timestamps):

```bash
docker-compose logs -f -t
```

* Single service:

```bash
docker-compose logs -f my-ggo-cuentas
```

---

## 🐳 Docker Commands Reference

| #  | Command                                                                                                                       | Description                                        |
| -- | ----------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| 1  | `docker ps -a`                                                                                                                | List all containers (running/stopped)              |
| 2  | `docker stop <CONTAINER_NAME>`                                                                                                | Stop a container                                   |
| 3  | `docker rm <CONTAINER_NAME>`                                                                                                  | Remove a container                                 |
| 4  | `docker build -t <IMAGE_NAME>:<TAG> .`                                                                                        | Build Docker image from Dockerfile                 |
| 5  | `docker run -d --network <NETWORK_NAME> --env-file .env -p <HOST_PORT>:<CONTAINER_PORT> --name <CONTAINER_NAME> <IMAGE_NAME>` | Start container in detached mode                   |
| 6  | `docker exec -it <CONTAINER_NAME> bash`                                                                                       | Open interactive shell inside a container          |
| 7  | `docker logs -f <CONTAINER_NAME>`                                                                                             | Follow logs for a container                        |
| 8  | `docker network create <NETWORK_NAME>`                                                                                        | Create custom Docker network                       |
| 9  | `apt update && apt install -y mysql-client`                                                                                   | Install MySQL client inside a container (optional) |
| 10 | `mysql -h <MYSQL_CONTAINER_NAME> -u<USER> -p<PASSWORD> -D <DB>`                                                               | Test MySQL connection from container               |
| 11 | `ping <OTHER_CONTAINER_NAME>`                                                                                                 | Test connectivity between containers               |

> 💡 Tip: Replace placeholders (`<CONTAINER_NAME>`, `<IMAGE_NAME>`, `<NETWORK_NAME>`) with actual names like `my-crud`, `crud:1.0`, `mi-red`.

---

## 🔑 Redis Keys Management

* **Set keys:**

```bash
SET "security_key:test:public" "<PUBLIC_KEY>"
SET "security_key:test:private" "<PRIVATE_KEY>"
```

* **Verify keys:**

```bash
KEYS security_key:*
GET "security_key:test:public"
GET "security_key:test:private"
```

---

## 💡 Best Practices

1. Always stop & remove old containers before rebuilding images.
2. Use `.env` files for secrets and environment variables.
3. Keep each microservice in its own Docker image for modularity.
4. Use `depends_on` + `healthcheck` in Docker Compose to manage service startup order.
5. Monitor logs and container health to detect issues early.

---

## 🔧 Quick Workflow Example

```bash
# 1️⃣ Stop & remove old container
docker stop my-ggo-cuentas
docker rm my-ggo-cuentas

# 2️⃣ Rebuild project
mvn clean package

# 3️⃣ Build Docker image
docker build -t ggo-cuentas:1.0 .

# 4️⃣ Run container
docker run -d --name my-ggo-cuentas --network mi-red -p 8082:8082 --env-file .env ggo-cuentas:1.0
```
