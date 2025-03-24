# TodoList API - Spring Boot

Une API RESTful de gestion de tâches développée avec Spring Boot et PostgreSQL.

## 📋 Technologies utilisées
- **Spring Boot 3**
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## ⚙️ Prérequis
- Java 17+
- Maven 3.6+
- PostgreSQL 15+
- Postman ou un client HTTP similaire (pour les tests)

## 🛠 Installation

1. **Cloner le dépôt**
```bash
git clone (https://github.com/jakemelvin/todolist)
Configurer la base de données

Créer une base PostgreSQL nommée todolist_db

Créer un utilisateur avec les identifiants :

Utilisateur: postgres

Mot de passe: Ines@2023

Configurer l'application
Le fichier application.properties est déjà configuré avec :

Port: 8080

Connexion à la base locale

Auto-update du schéma de base

🚀 Lancer l'application
Avec Maven :
mvn spring-boot:run

📡 Endpoints API
Base URL : http://localhost:8080/api/v1/tasks

Méthode	Endpoint	Description
GET	/	Récupérer toutes les tâches
GET	/get-by?status={status}	Filtrer les tâches par statut
POST	/create	Créer une nouvelle tâche
PUT	/update?taskId={id}	Mettre à jour une tâche existante
DELETE	/delete?taskId={id}	Supprimer une tâche

Lien du Swagger: http://localhost:8080/swagger-ui/index.html#/

Ce README inclut :
1. Les instructions d'installation et configuration
2. La documentation complète des endpoints
3. Des exemples de requêtes prêtes à l'emploi
4. Les procédures de dépannage courantes
5. Les références techniques

Vous pouvez l'adapter selon vos besoins spécifiques (ajouter une section sur les tests, l'environnement de production, etc.).

