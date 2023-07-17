package com.jwt.jwt.service;

import com.jwt.jwt.domain.member.MemberReqDto;
import com.jwt.jwt.domain.member.Member;
import com.jwt.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Value("${jwt.secret}")
    private String secretKey;


    // 회원 가입
    @Transactional
    public Member register(MemberReqDto memberReqDto) {

        validateDuplicateMember(memberReqDto);

        Member member = Member.createMember(memberReqDto);
        memberRepository.save(member);

        return member;
    }


    // 회원 가입 :: 사용자 중복 검사, 닉네임 중복 검사
    private void validateDuplicateMember(MemberReqDto member) {

        // 중복 회원 검사
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (! findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        // 중복 닉네임 검사
        List<Member> findNickName = memberRepository.findByNickName(member.getNickName());
        if (! findNickName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임 입니다.");
        }

    }

    // 로그인
    public Member login(String email, String password) {
        // 이메일 조회
        Optional<Member> findMember = memberRepository.findOneEmail(email);

        if(!findMember.orElseThrow(()->new IllegalStateException("해당 이메일이 존재하지 않습니다.")).checkPassword(password)){
            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
        }
        return findMember.get();

//        if (findMember.isEmpty()) {
//            throw new IllegalStateException("이메일이 존재하지 않습니다.");
//        }
//
//        // 비밀번호 체크
//        if (! findMember.get().checkPassword(password)) {
//            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
//        }
//
//        return findMember.get();
    }



}
