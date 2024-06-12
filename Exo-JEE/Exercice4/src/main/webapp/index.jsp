<%@ page import="com.swino.exercice4.Chat" %>
<jsp:useBean id="chats" type="java.util.ArrayList<com.swino.exercice4.Chat>" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des Chats</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Liste des Chats</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Repas Favoris</th>
            <th>Date de Naissance</th>
        </tr>
        </thead>
        <tbody>
        <% for (Chat chat : chats) { %>
        <tr>
            <td><%= chat.getNom() %></td>
            <td><%= chat.getRace() %></td>
            <td><%= chat.getRepasFavoris() %></td>
            <td><%= chat.getDateNaissance() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <a href="addChat.jsp" class="btn btn-primary">Ajouter un Chat</a>
</div>
</body>
</html>
