package com.pintor.marketapp.market.entity;

import com.pintor.marketapp.base.entity.BaseEntity;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.product.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Market extends BaseEntity {

    private String name;

    private String info;

    private String email;

    @OneToOne
    private Member owner;

    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE)
    private List<Product> productList;
}
