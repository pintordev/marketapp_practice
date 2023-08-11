package com.pintor.marketapp.answer.entity;

import com.pintor.marketapp.base.entity.BaseEntity;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.question.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer extends BaseEntity {

    private String content;

    @OneToOne
    private Member owner;

    @OneToOne
    private Question question;
}
