<%@ page import="com.swino.exochien.entities.Chien" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Chiens</title>
</head>
<body>
<h1>Liste des Chiens</h1>
<a href="ajouterChien">Ajouter un nouveau chien</a>
<table border="1">
    <tr>
        <th>Nom</th>
        <th>Race</th>
        <th>Date de Naissance</th>
        <th>Détails</th>
    </tr>
    <%
        List<Chien> chiens = (List<Chien>) request.getAttribute("chiens");
        for (Chien chien : chiens) {
    %>
    <tr>
        <td><%= chien.getNom() %></td>
        <td><%= chien.getRace() %></td>
        <td><%= chien.getDateDeNaissance() %></td>
        <td><a href="detailsChien?id=<%= chien.getId() %>">Voir détails</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
