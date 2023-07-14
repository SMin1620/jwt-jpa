package com.jwt.jwt.service;

import com.jwt.jwt.dto.MemberReqDto;
import com.jwt.jwt.model.Member;
import com.jwt.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Long register(MemberReqDto requestDto) {

        validateDuplicateMember(requestDto);
        Member member = requestDto.toEntity();

        memberRepository.save(member);
        return member.getId();
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



}