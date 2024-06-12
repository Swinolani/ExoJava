<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Chien</title>
</head>
<body>
<h1>Ajouter un Chien</h1>
<form action="ajouterChien" method="post">
    Nom : <input type="text" name="nom" required/><br/>
    Race : <input type="text" name="race" required/><br/>
    Date de Naissance : <input type="date" name="dateDeNaissance" required/><br/>
    <input type="submit" value="Ajouter"/>
</form>
<a href="chiens">Retour à la liste</a>
</body>
</html>
