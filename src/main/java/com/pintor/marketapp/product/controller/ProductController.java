package com.pintor.marketapp.product.controller;

import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public String list(Model model) {

        List<Product> productList = this.productService.getList();
        model.addAttribute("productList", productList);

        return "product/list";
    }
}
