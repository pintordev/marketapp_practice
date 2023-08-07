package com.pintor.marketapp.member.repository;

import com.pintor.marketapp.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
