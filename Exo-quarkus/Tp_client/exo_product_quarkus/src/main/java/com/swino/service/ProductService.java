package com.swino.service;

import com.swino.entity.Product;
import com.swino.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.listAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findByIdOptional(id);
    }

    public Product addProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product updateProduct(Product product) {
        return productRepository.getEntityManager().merge(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}