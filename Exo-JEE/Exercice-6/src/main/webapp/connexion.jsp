<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
<h2>Connexion</h2>
<form action="UserServlet" method="post">
    <label for="email">Email :</label>
    <input type="email" id="email" name="email" required><br><br>
    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="connexion" name="action">
</form>
<p>Pas encore inscrit ? <a href="inscription.jsp">Inscription</a></p>
</body>
</html>
