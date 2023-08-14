package com.pintor.marketapp.member.service;

import com.pintor.marketapp.DataNotFoundException;
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

    public Member create(String username, String password, String nickname, String email) {

        Member member = new Member();

        member.setUsername(username);
        member.setPassword(this.passwordEncoder.encode(password));
        member.setNickname(nickname);
        member.setEmail(email);
        member.setCreateDate(LocalDateTime.now());

        this.memberRepository.save(member);

        return member;
    }

    public Member getMemberByUsername(String username) {

        return this.memberRepository.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException("member not found"));
    }
}
