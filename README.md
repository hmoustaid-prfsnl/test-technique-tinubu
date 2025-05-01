# 🛡️ Insurance Policy Management API

Application Spring Boot pour la gestion de polices d'assurance, incluant la création, la lecture, la mise à jour, la pagination, le tri, la documentation Swagger, l'accès à la base H2, et la conteneurisation Docker.

---

## 🚀 Fonctionnalités

- CRUD complet sur les polices d'assurance
- Pagination et tri par nom, date...
- Swagger UI pour la documentation interactive
- Console H2 activée (avec `web-allow-others` pour Docker)
- Dockerfile multi-stage (build Maven + exécution JRE)

---

## 🧑‍💻 Technologies utilisées

- Java 21
- Spring Boot 3
- Spring Data JPA
- Lombok, MapStruct
- H2 Database (mode mémoire)
- Maven 3.9+
- Docker

---

## 📦 Installation locale

### Prérequis

- JDK 21
- Maven 3.9+
- Docker (optionnel pour conteneuriser)

### Compilation & exécution

```bash
mvn clean install
mvn spring-boot:run
```

### Accès à l'application

- Swagger UI : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Console H2 : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - JDBC URL : `jdbc:h2:mem:insurance_db`
  - User : `sa`
  - Password : 

---

## 💡 Structure du projet

```
src/main/java/com/tinubu/insurance
├── config/       # Configuration (Swagger, etc.)
├── controller/   # Contrôleurs REST
├── dto/          # DTOs (Create, Update, Response)
├── exception/    # Gestion des erreurs personnalisées
├── mapper/       # Interface MapStruct pour la conversion DTO ↔ Entity
├── model/        # Entités JPA (ex: InsurancePolicy)
├── repository/   # Interfaces JPARepository
└── service/      # Services métier (implémentations, interfaces)
```

---

## 🛠 Docker

### Création de l'image Docker

```bash
docker build -t insurance-app .
```

### Exécution du conteneur

```bash
docker run -p 8080:8080 insurance-app
```

Puis accédez à :
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 📊 Swagger & OpenAPI

Swagger UI est automatiquement accessible :

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- OpenAPI JSON : [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---
