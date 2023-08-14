package com.pintor.marketapp.cart.entity;

import com.pintor.marketapp.base.entity.BaseEntity;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cart extends BaseEntity {

    @ManyToOne
    private Member owner;

    @ManyToOne
    private Product product;
}
