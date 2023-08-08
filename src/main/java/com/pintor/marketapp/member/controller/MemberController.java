package com.pintor.marketapp.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class MemberController {

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "로그인 페이지 입니다.";
    }

    @GetMapping("/join")
    @ResponseBody
    public String join() {
        return "회원가입 페이지 입니다.";
    }
}
