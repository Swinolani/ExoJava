package com.swino.trainingsecurity.service;

import com.swino.trainingsecurity.entity.Product;
import com.swino.trainingsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements UserDetailsService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrize(productDetails.getPrize());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
