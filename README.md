## Exemple Spring Boot et Open Feign Client
Dans ce projet, nous allons apprendre à configurer un FeignClient dans votre projet Spring Boot pour 
utiliser les API RESTFul d'autres services.  Nous effectuerons également les opérations de base CRUD - POST/GET/PUT/DELETE 
(Create, Read, Update, Delete) d'une entité - `Post`.

### Aperçu
---
**FeignClient** est un client REST déclaratif dans l'application Web Spring Boot. Le client REST déclaratif 
signifie que vous donnez simplement la spécification du client en tant qu'interface et que Spring Boot 
s'occupe de l'implémentation pour vous.<br/>

FeignClient est utilisé pour consommer les points de terminaison d'API RESTFul exposés par un tiers ou un microservice.

### Feign vs RestTemplate
---
Il s'agit d'une alternative à RestTemplate et présente les avantages suivants par rapport à RestTemplate : - <br/>
* Pas besoin d'écrire des classes d'implémentation pour appeler d'autres services, il suffit de fournir une spécification en tant qu'interface
* Les configurations client telles que l'encodage/décodage, le délai d'attente, la journalisation peuvent simplement être effectuées via des fichiers de propriétés .
* Les configurations client peuvent également être effectuées à partir du fichier de configuration Java .
* Développé par Netflix. Il a un excellent support pour fonctionner avec d'autres bibliothèques cloud à démarrage à ressort telles que Hystrix, Eureka et Ribbon
* Spring Boot prend en charge l' écriture de cas de test pour Feign Client à l' aide de WireMock
* Fournir une prise en charge des données de secours en cas d'échec de l'appel d'API.

### Prérequis
---
Pour ce projet, vous auriez besoin des spécifications suivantes :<br/>
- Spring Boot v2.0+
- JDK v1.8+
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- Postman, curl ou n'importe quel client HTTP pour tester l'API REST

### Dependances Maven
---
Dans ce projet nous allons utiliser les dependances Maven suivants :<br/>
- **Spring Web** - Pour inclure Spring MVC et utilise le tomcat comme conteneur intégré par défaut.
- **Spring Boot DevTools** - Dépendance pour les rechargements automatiques ou le rechargement en direct des applications.
- **spring-cloud-starter-openfeign** - Un client REST déclaratif pour les applications Spring Boot
- **springdoc-openapi-ui** Dépendances pour la documentation de l'API Swagger 3.

### Créer un client fictif
---
Nous allons créer un FeignClient à consommer à partir du point de terminaison de l'API RESTFul. Créons une `PostFeignClientinterface` - <br/>
* Annoté avec `@FeignClient` quelle analyse automatique par l'application de démarrage de printemps pour générer un client fictif
* Ce FeignClient consomme les API de cette URL : `https://jsonplaceholder.typicode.com/`

### Architecture technique
---
Cette image présente l'architecture globale du projet.<br/><br/>

Le module au cœur du Spring Framework (Spring Core) repose fondamentalement sur un seul principe de conception objet : l’inversion de contrôle.<br/>
	
L'**Inversion de contrôle (Spring IOC)** permet au développeur de s'occuper uniquement du code metier (Exigences fonctionnelles) 
et c'est le Framework qui s'occupe du code technique (Exigences Techniques).

### Exigences technique
---
* Un client web (Browser) communique avec le serveur web (Apache) en utilisant le protocole HTTP.
* Les données sont stockées dans MongoDB.
* L'application est composé de 4 couches :
	- La couche de données (DTO) pour les classes POJO.
	- La couche businessdelegate pour interagir avec le client Feign.
	- La couche métier pour le traitement de la logique métier.
	- La couche infrastructure (controller) basée sur Rest API pour traiter la logique d'entreprise.

### Tester les APIs REST
---
`$ mvn spring-boot:run`<br/><br/>
Pour tester les APIs vous pouvez utiliser Postman, Swagger, curl ou n'importe quel client HTTP :<br/>
* GET `/api/posts` - Récupérer tous les posts.
* GET `/api/posts/{postId}` - Récupérer un post existant.
* GET `/api/posts/userId/{userId} - Récupérer tous les post d'un utilisateur.
* POST `/api/posts/add - Ajouter un post.
* PUT `/api/posts/update/{postId} - Mettre à jour un post.
* DELETE `/api/posts/delete/{postId} - Supprimer un post.

Une fois l'application lancer il faut vérifier que le swagger est UP en checkant l'url suivante : `http://localhost:8080/v3/api-docs`* <br/>
Utilisez un client REST comme postman pour importer la collection des WS en utilisant url : `http://localhost:8080/v3/api-docs`*

### Installation
---
* git clone `https://github.com/darvin-rakotomalala/spring-boot-open-feign-client-exemple.git`
* cd spring-boot-open-feign-client-exemple
* mvn clean package
* java -jar target/spring-boot-open-feign-client-exemple-0.0.1.jar