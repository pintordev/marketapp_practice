package com.pintor.marketapp.service;

import com.pintor.marketapp.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

//    @Test
//    @DisplayName("강의 제품 생성")
//    void createProductTest() {
//
//        for (int i = 2; i <= 200; i++) {
//
//            String name = String.format("테스트 상품 [%03d]", i);
//            int price = 1;
//
//            this.productService.create(name, price);
//        }
//    }
}
