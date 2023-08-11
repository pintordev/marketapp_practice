package com.pintor.marketapp.product.entity;

import com.pintor.marketapp.base.entity.BaseEntity;
import com.pintor.marketapp.market.entity.Market;
import com.pintor.marketapp.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {

    private String name;

    private String description;

    private Integer price;

    private Integer hitCount;

    private String isActive;

    @ManyToOne
    private Market market;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Question> questionList;
}
