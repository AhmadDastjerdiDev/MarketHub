package com.example.markethub1.Product.repository;

import com.example.markethub1.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
