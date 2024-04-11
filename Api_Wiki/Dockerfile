# Utiliser une image de base officielle Java avec JDK
FROM openjdk:17-oracle

# Copier le fichier .jar de l'application dans l'image Docker
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Exposer le port sur lequel votre application va écouter
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
