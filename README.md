#  Étude de cas : Clients Synchrones (RestTemplate vs Feign vs WebClient) avec Eureka et Consul

## Objectifs pédagogiques
À la fin du lab, il sera possible de :
* Implémenter deux microservices communiquant synchroniquement
* Configurer la découverte de services avec Eureka et avec Consul
* Implémenter 3 clients HTTP côté Service Client : RestTemplate, Feign, WebClient
* Réaliser des tests de performance (latence / débit) et collecter des métriques
* Tester la résilience (panne service voiture, panne discovery, etc.) et analyser les résultats

## Prérequis
* Java 17+ (ou 11+)
* Maven
* Un IDE (IntelliJ/Eclipse)
* Postman ou curl
* JMeter (recommandé) pour charge
* (Optionnel) Docker + Docker Compose
* (Optionnel) Prometheus + Grafana pour métriques
* Eureka ou Consul (selon scénario du lab)

## Architecture cible
Services à créer :
* Service Voiture (expose l’API des voitures)
* Service Client (consomme l’API Voiture avec 3 techniques)
* Discovery : Eureka OU Consul (les deux seront testés)
Flux principal :
* Service Client → (RestTemplate / Feign / WebClient) → Service Voiture
* Résolution du nom logique via Eureka ou Consul
<img width="553" height="296" alt="image" src="https://github.com/user-attachments/assets/fdc22a0a-0d42-41de-b5bc-cf7b88920659" />

## Auteur
* Nom : BEN-LAGHFIRI Majeda
* Cours: Architecture Microservices : Conception, Déploiement et Orchestration
* Date : Janvier 2026
* Encadré par : Pr.Mohamed LACHGAR
