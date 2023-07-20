package com.jwt.jwt.member.repository;

import com.jwt.jwt.common.Role;
import com.jwt.jwt.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
//    List<Member> findAllRole(Role role);
}
