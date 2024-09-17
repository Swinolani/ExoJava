# Étape 1: Construire l'application
FROM maven:3.8.4-openjdk-11 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier POM et les sources du projet
COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

# Télécharger les dépendances et construire le projet
RUN mvn clean package -DskipTests

# Étape 2: Créer l'image finale
FROM openjdk:11-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR construit depuis l'étape de build
COPY --from=build /app/target/common-data-service.jar common-data-service.jar

# Exposer le port que l'application utilise
EXPOSE 8080

# Définir la commande par défaut pour exécuter l'application
ENTRYPOINT ["java", "-jar", "common-data-service.jar"]
