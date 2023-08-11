package com.pintor.marketapp.question.entity;

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
public class Question extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    private Member questioner;

    @ManyToOne
    private Product product;
}
