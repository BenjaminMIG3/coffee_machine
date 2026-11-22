# Coffee Machine

Petit projet Spring Boot (cours EPITA) : API REST pour gérer des cafés.

## Lancer le projet

```bash
./mvnw spring-boot:run
```

## Endpoints

- `GET /coffees` — liste des cafés
- `GET /coffees/{id}` — un café
- `POST /coffees` — créer un café
- `PATCH /coffees/{id}` — mise à jour partielle

Base H2 en mémoire + données de démo au démarrage.
