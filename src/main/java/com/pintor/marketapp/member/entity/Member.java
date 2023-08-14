package com.pintor.marketapp.member.entity;

import com.pintor.marketapp.base.entity.BaseEntity;
import com.pintor.marketapp.cart.entity.Cart;
import com.pintor.marketapp.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Member extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    private String nickname;

    private String email;

    private String isActive;

    @OneToMany(mappedBy = "questioner", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Cart> cartList;
}
