# Utiliser une image de base officielle Java avec JDK
FROM openjdk:17-oracle

# Copier le fichier .jar de l'application dans l'image Docker
COPY target/Api_Wiki-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel votre application va écouter
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "/app.jar"]