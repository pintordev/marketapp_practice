package com.pintor.marketapp.cart.service;

import com.pintor.marketapp.cart.entity.Cart;
import com.pintor.marketapp.cart.repository.CartRepository;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;


    public Cart add(Product product, Member owner) {

        Cart cart = new Cart();

        cart.setOwner(owner);
        cart.setProduct(product);
        cart.setCreateDate(LocalDateTime.now());

        this.cartRepository.save(cart);

        return cart;
    }

    public List<Cart> getList(Member owner) {
        return this.cartRepository.findByOwner(owner);
    }
}
