package com.pintor.marketapp.member.controller;

import com.pintor.marketapp.member.form.MemberForm;
import com.pintor.marketapp.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/join")
    public String join(MemberForm memberForm) {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@Valid MemberForm memberForm, BindingResult bindingResult) {

        this.memberService.create(memberForm.getUsername(), memberForm.getPassword(), memberForm.getNickname(), memberForm.getEmail());

        return "redirect:/member/login";
    }
}
