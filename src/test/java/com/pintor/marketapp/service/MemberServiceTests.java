package com.pintor.marketapp.service;

import com.pintor.marketapp.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

//    @Test
//    @DisplayName("회원 생성")
//    public void createMemberTest() {
//
//        String username = "user1";
//        String password = "1234";
//        String email = "test@test.dev";
//        String nickname = "tester1";
//
//        this.memberService.create(username, password, email, nickname);
//    }
}
