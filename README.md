Application de Gestion de Cantine
Description
L'application de gestion de cantine permet de gérer les menus et les plats proposés dans la cantine. Chaque menu est lié à un plat, et chaque plat peut être associé à un menu à un moment donné. L'objectif principal de cette application est de faciliter la création, la modification et la suppression de menus et de plats dans la base de données.

Modèles
Menu
Le modèle Menu représente un menu dans la cantine. Il contient les informations suivantes :

id (Long) : L'identifiant unique du menu.
creation_date (Date) : La date de création du menu.
Chaque Menu est lié à un Plat.

Plat
Le modèle Plat représente un plat proposé dans le menu de la cantine. Il contient les informations suivantes :

id (Long) : L'identifiant unique du plat.
name (String) : Le nom du plat.
summary (String) : Une description ou résumé du plat.
Chaque Plat est lié à un Menu.

Relations
Menu - Plat : Un menu est toujours associé à un seul plat et un plat est toujours associé à un seul menu (relation un-à-un).
Fonctionnalités
L'application de gestion de cantine offre les fonctionnalités suivantes :

Création de menu : Créer un nouveau menu et lui associer un plat existant ou nouveau.
Modification de menu : Modifier les détails d'un menu existant et son plat associé.
Suppression de menu : Supprimer un menu existant.
Création de plat : Créer un nouveau plat.
Modification de plat : Modifier les détails d'un plat existant.
Suppression de plat : Supprimer un plat existant.
Technologies Utilisées
Java : Pour la logique métier.
Spring Boot : Pour la gestion des services web, la persistance des données, et l'architecture MVC.
Hibernate : Pour la gestion des entités et de la base de données relationnelle.
Thymeleaf : Pour les vues côté client.
PostgreSQL : Base de données relationnelle pour stocker les informations sur les menus et les plats.
Installation et Configuration
Prérequis
Java 17 
PostgreSQL
Maven
Étapes d'installation
Cloner le dépôt :

bash
Copier le code
https://github.com/gerard-ks/GestCantineADA.git
Configurer la base de données :

Dans le fichier application.properties (ou application.yml), configurez les paramètres de connexion à la base de données :

properties
Copier le code
spring.application.name=GestCantineADA
server.port=8081
spring.datasource.url=jdbc:postgresql://localhost:5432/cantine_db
spring.datasource.username=postgres
spring.datasource.password=azerty
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

bash
Copier le code
mvn clean install
mvn spring-boot:run
Accéder à l'application : Ouvrez votre navigateur et rendez-vous à l'URL suivante :

arduino
Copier le code
http://localhost:8081
API Endpoints
Menu
GET /menu/{id} : Récupère les détails d'un menu par son ID.
POST /menu : Crée un nouveau menu.
PUT /menu/{id} : Modifie un menu existant.
DELETE /menu/{id} : Supprime un menu.
Plat
GET /plat/{id} : Récupère les détails d'un plat par son ID.
POST /plat : Crée un nouveau plat.
PUT /plat/{id} : Modifie un plat existant.
DELETE /plat/{id} : Supprime un plat.
Structure du Projet
bash
Copier le code
src/
│
├── main/
│   ├── java/
│   │   └── com/entreprise/cantine/
│   │       ├── controller/    # Contrôleurs REST pour Menu et Plat
│   │       ├── model/         # Entités JPA (Menu, Plat)
│   │       ├── repository/    # Interfaces des repositories Spring Data JPA
│   │       └── service/       # Services pour la gestion de la logique métier
│   └── resources/
│       ├── templates/         # Vues Thymeleaf
│       └── application.properties  # Configuration de l'application
│
└── test/                      # Tests unitaires et d'intégration
