package org.example.Factory;

import org.example.Entity.AbstractProductBuilder;
import org.example.Entity.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(AbstractProductBuilder builder);
}
