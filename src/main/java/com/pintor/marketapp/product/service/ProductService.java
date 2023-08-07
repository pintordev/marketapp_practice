package com.pintor.marketapp.product.service;

import com.pintor.marketapp.DataNotFoundException;
import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Product getProduct(Long id) {

        Optional<Product> _product = this.productRepository.findById(id);
        if (_product.isPresent()) {
            return _product.get();
        } else {
            throw new DataNotFoundException("product not found");
        }
    }
}
