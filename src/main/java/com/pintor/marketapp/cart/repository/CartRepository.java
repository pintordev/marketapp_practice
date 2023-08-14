package com.pintor.marketapp.cart.repository;

import com.pintor.marketapp.cart.entity.Cart;
import com.pintor.marketapp.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByOwner(Member owner);
}
