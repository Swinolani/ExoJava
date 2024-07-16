package com.swino.trainingsecurity.repository;

import com.swino.trainingsecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
