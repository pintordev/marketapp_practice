package com.pintor.marketapp.security;

import com.pintor.marketapp.member.entity.Member;
import com.pintor.marketapp.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class CustomSecurityService extends DefaultOAuth2UserService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = this.memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));

        return new CustomDetails(member);
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, String> attributes = new SocialInfo(userRequest, oAuth2User).getAttributes();

        Member member = this.memberRepository.findByUsername(attributes.get("providerId"))
                .orElse(null);

        if (member == null) {

            member = new Member();

            member.setUsername(attributes.get("providerId"));
            member.setPassword("");
            member.setNickname(attributes.get("name"));
            member.setEmail(attributes.get("email"));

            this.memberRepository.save(member);
        }

        return new CustomDetails(member);
    }
}
