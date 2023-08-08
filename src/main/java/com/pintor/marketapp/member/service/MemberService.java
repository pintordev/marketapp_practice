package com.pintor.marketapp.member.service;

import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String password, String email, String nickname) {

        Member member = new Member();

        member.setUsername(username);
        member.setPassword(this.passwordEncoder.encode(password));
        member.setEmail(email);
        member.setNickname(nickname);
        member.setCreateDate(LocalDateTime.now());

        this.memberRepository.save(member);

        return member;
    }
}
