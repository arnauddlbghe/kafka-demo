# Découverte de Kafka

Ressources utilisées:
- [Vidéo YouTube "Apache Kafka Tutorial with Spring Boot Reactive & WebFlux | Kafka Tutorial" par Ali Bouali](https://www.youtube.com/watch?v=KQDTtvZMS9c)
- [Documentation officiel de Kafka](https://kafka.apache.org/documentation/#quickstart)

## Démarrer le serveur.

```shell
# Permet de démarrer le serveur Zookeeper
# Commande à maintenir active.
bin/zookeeper-server-start.sh config/zookeeper.properties

# Permet de démarrer le serveur Kafka (a besoin du serveur Zookeper)
# Commande maintenir active.
bin/kafka-server-start.sh config/server.properties

# Permet de démarrer notre API (a besoin du serveur Kafka)
./mvnw spring-boot:run
```

## Routes disponibles

| Verbe | Path                     | Body    | Curl Example                                                                                                 |
|-------|--------------------------|---------|--------------------------------------------------------------------------------------------------------------|
| POST  | /api/v1/messages         | String  | `curl -X POST -H "Content-Type: text/plain" http://localhost:8080/api/v1/messages --data "sending raw data"` |
| POST  | /api/v1/messages/student | Student | `curl -X POST http://localhost:8080/api/v1/messages/student -H 'Content-Type: application/json' -d '{"id":"1","firstName":"Hello","lastName":"World"}'`                                                                                                             |

