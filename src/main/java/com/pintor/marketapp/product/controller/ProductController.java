package com.pintor.marketapp.product.controller;

import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.service.ProductService;
import com.pintor.marketapp.question.form.QuestionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public String list(Model model) {

        List<Product> productList = this.productService.getList();
        model.addAttribute("productList", productList);

        return "product/list";
    }

    @GetMapping("{id}")
    public String detail(Model model, @PathVariable("id") Long id,
                         QuestionForm questionForm) {

        Product product = this.productService.getProduct(id);
        model.addAttribute("product", product);

        return "product/detail";
    }
}
