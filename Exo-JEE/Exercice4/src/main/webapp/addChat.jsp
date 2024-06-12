<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Chat</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Ajouter un Chat</h1>
    <form action="ChatServlet" method="post">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="race">Race</label>
            <input type="text" class="form-control" id="race" name="race" required>
        </div>
        <div class="form-group">
            <label for="repasFavoris">Repas Favoris</label>
            <input type="text" class="form-control" id="repasFavoris" name="repasFavoris" required>
        </div>
        <div class="form-group">
            <label for="dateNaissance">Date de Naissance</label>
            <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
</body>
</html>
