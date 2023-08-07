package com.pintor.marketapp.product.service;

import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(String name, int price) {

        Product product = new Product();

        product.setName(name);
        product.setPrice(price);
        product.setCreateDate(LocalDateTime.now());

        this.productRepository.save(product);

        return product;
    }

    public List<Product> getList() {

        return this.productRepository.findAll();
    }
}
