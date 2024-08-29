import numpy as np
from sklearn.datasets import make_regression
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

model = LinearRegression()
X, y = make_regression(n_samples=10, n_features=1, noise=2, bias=0.7)

list_nombre = [-4, -3, -2, -1, 0, 1, 2, 3, 4, 5]

if __name__ == "__main__":
    model.fit(X, y)
    model.score(X, y)
    print(model.predict(np.array([2.5]).reshape(-1, 1)))

    plt.scatter(np.squeeze(X), y, color='blue', marker='o')

    plt.title("Dataset made by BOULAABI")
    plt.xlabel("Feature")
    plt.ylabel("Label")
    plt.plot(list_nombre, list_nombre * model.coef_, color='red')
    plt.show()
