package com.pintor.marketapp.question.service;

import com.pintor.marketapp.DataNotFoundException;
import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.question.entity.Question;
import com.pintor.marketapp.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question create(String title, String content, Member questioner, Product product) {

        Question question = new Question();

        question.setTitle(title);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        question.setQuestioner(questioner);
        question.setProduct(product);

        this.questionRepository.save(question);

        return question;
    }

    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("question not found"));
    }

    public void modify(Question question, String content) {

        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());

        this.questionRepository.save(question);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
