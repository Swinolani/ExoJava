<%@ page import="com.swino.exochien.entities.Chien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails du Chien</title>
</head>
<body>
<h1>Détails du Chien</h1>
<%
    Chien chien = (Chien) request.getAttribute("chien");
%>
<p>Nom : <%= chien.getNom() %></p>
<p>Race : <%= chien.getRace() %></p>
<p>Date de Naissance : <%= chien.getDateDeNaissance() %></p>
<a href="chiens">Retour à la liste</a>
</body>
</html>
