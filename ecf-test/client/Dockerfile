# Étape 1 : Construction de l'application
FROM node:12 AS build

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier package.json et yarn.lock (s'il existe)
COPY package.json yarn.lock ./

# Installe les dépendances
RUN yarn install

# Copie tout le contenu du projet
COPY . .

# Compile l'application
RUN yarn build

# Étape 2 : Servir l'application avec Nginx
FROM nginx:alpine

# Copie les fichiers construits dans le dossier Nginx par défaut
COPY --from=build /app/build /usr/share/nginx/html


# Expose le port 80
EXPOSE 80

# Commande de démarrage de Nginx
CMD ["nginx", "-g", "daemon off;"]
