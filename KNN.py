import numpy as np
from sklearn.datasets import make_classification
from sklearn.model_selection import train_test_split, GridSearchCV, learning_curve
from sklearn.model_selection import ShuffleSplit
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import confusion_matrix
import matplotlib.pyplot as plt

# Création des données
X, Y = make_classification(n_samples=100, n_features=5, n_classes=3, class_sep=2, n_informative=3)

# Génération des données de test et d'entrainement/validation
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=5)

# Création du modèle KNN
model = KNeighborsClassifier(n_neighbors=5, metric="euclidean")

# Preparer la validation croisée
ss = ShuffleSplit(n_splits=5, test_size=0.2, random_state=5)

# Préparer la recherche en grille de l'estimateur des meilleurs métriques
param_grid = {"metric": ['manhattan', 'euclidean'], 'n_neighbors': np.linspace(1, 15, 15).astype(int)}
grid_search = GridSearchCV(model, param_grid, cv=ss)

# Entrainement du modèle
grid_search.fit(X_train, Y_train)

# Affichage de la courbe d'apprentissage et de validation
train_size_abs,train_score,test_score=learning_curve(grid_search.best_estimator_,X_train,Y_train,train_sizes=np.linspace(0.1,1,10))
train_score_mean = np.mean(train_score, axis=1)
test_score_mean = np.mean(test_score, axis=1)
plt.title("Comparatif scoring validation/entrainement")
plt.plot(train_size_abs,train_score_mean,color='red')
plt.plot(train_size_abs,test_score_mean,color='green')
plt.xlabel("number_dataset")
plt.ylabel("score")

if __name__ == "__main__":
    # Préparer la liste des prédiction des tests
    Y_pred = grid_search.predict(X_test)

    print("Voici les meilleur estimateurs :", grid_search.best_estimator_)
    print()
    print("La matrice de confusion :")
    print(confusion_matrix(Y_test, Y_pred))
    print()
    plt.show()
