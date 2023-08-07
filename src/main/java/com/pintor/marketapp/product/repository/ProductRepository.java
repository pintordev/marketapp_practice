package com.pintor.marketapp.product.repository;

import com.pintor.marketapp.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
