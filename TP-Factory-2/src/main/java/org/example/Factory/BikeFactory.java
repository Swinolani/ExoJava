package org.example.Factory;

import org.example.Entity.AbstractProductBuilder;
import org.example.Entity.Product;

public class BikeFactory extends  ProductFactory{
    @Override
    public Product createProduct(AbstractProductBuilder builder) {
        return builder.build();
    }
}
