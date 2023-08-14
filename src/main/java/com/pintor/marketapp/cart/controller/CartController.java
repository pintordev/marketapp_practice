package com.pintor.marketapp.cart.controller;

import com.pintor.marketapp.cart.entity.Cart;
import com.pintor.marketapp.cart.service.CartService;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.member.service.MemberService;
import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@RequestMapping("/cart")
@RequiredArgsConstructor
@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("")
    public String list(Model model, Principal principal) {

        Member owner = this.memberService.getMemberByUsername(principal.getName());

        List<Cart> cartList = this.cartService.getList(owner);
        model.addAttribute("cartList", cartList);

        return "cart/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public String add(@RequestParam("productId") Long productId, Principal principal) {

        Product product = this.productService.getProduct(productId);
        Member owner = this.memberService.getMemberByUsername(principal.getName());

        Cart cart = this.cartService.add(product, owner);

        return "redirect:/cart";
    }
}
