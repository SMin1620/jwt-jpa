package com.jwt.jwt.repository;

import com.jwt.jwt.model.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // 회원가입
    public void save(Member member) {
        em.persist(member);
    }

    // 사용자 단일 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 사용자 전체 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 닉네임으로 사용자 전체 조회
    public List<Member> findByNickName(String nickName) {
        return em.createQuery("select m from Member m where m.nickName = :nickName", Member.class)
                .setParameter("nickName", nickName)
                .getResultList();
    }

    // userName 아이디 전체 조회
    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }

}
