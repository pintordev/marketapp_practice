package com.pintor.marketapp.question.controller;

import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.member.service.MemberService;
import com.pintor.marketapp.product.entity.Product;
import com.pintor.marketapp.product.service.ProductService;
import com.pintor.marketapp.question.entity.Question;
import com.pintor.marketapp.question.form.QuestionForm;
import com.pintor.marketapp.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final MemberService memberService;
    private final ProductService productService;

    @PreAuthorize("isAuthenticated")
    @PostMapping("/create")
    public String create(@Valid QuestionForm questionForm, BindingResult bindingResult,
                         @RequestParam("productId") Long productId,
                         Principal principal) {

        Member questioner = this.memberService.getMemberByUsername(principal.getName());
        Product product = this.productService.getProduct(productId);

        Question question = this.questionService.create(questionForm.getTitle(), questionForm.getContent(), questioner, product);

        return String.format("redirect:/product/%s", question.getProduct().getId());
    }

    @PreAuthorize("isAuthenticated")
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model, Principal principal) {

        Question question = this.questionService.getQuestion(id);

        if (!question.getQuestioner().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없다.");
        }

        model.addAttribute("question", question);

        return "question/modify";
    }

    @PreAuthorize("isAuthenticated")
    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, @RequestParam("content") String content,
                         Model model, Principal principal) {

        Question question = this.questionService.getQuestion(id);

        if (!question.getQuestioner().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없다.");
        }

        this.questionService.modify(question, content);

        return String.format("redirect:/product/%s", question.getProduct().getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {

        Question question = this.questionService.getQuestion(id);

        if (!question.getQuestioner().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없다.");
        }

        this.questionService.delete(question);

        return String.format("redirect:/product/detail/%s", question.getProduct().getId());
    }
}
