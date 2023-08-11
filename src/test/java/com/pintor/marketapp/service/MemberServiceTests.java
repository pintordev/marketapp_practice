package com.pintor.marketapp.service;

import com.pintor.marketapp.member.service.MemberService;
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
//        String nickname = "tester1";
//        String email = "test@test.dev";
//
//        this.memberService.create(username, password, nickname, email);
//    }
}
