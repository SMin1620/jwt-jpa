package com.jwt.jwt.member.service;

import com.jwt.jwt.member.dto.login.LoginReqDto;
import com.jwt.jwt.member.dto.login.LoginResDto;
import com.jwt.jwt.member.dto.register.RegisterReqDto;
import com.jwt.jwt.member.dto.register.RegisterResDto;
import com.jwt.jwt.member.entity.Member;
import com.jwt.jwt.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    /**
     * 회원 가입 로직
     */
    @Transactional
    public RegisterResDto register(RegisterReqDto request) {

        Member member = memberRepository.save(Member.fromEntity(request, passwordEncoder));

        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        return RegisterResDto.fromDto(member);
    }


    /**
     * 로그인 로직
     */
    public LoginResDto login(LoginReqDto request) {

        // 이메일 확인
        Optional<Member> member = memberRepository.findByEmail(request.getEmail());

        if (member.isPresent() && passwordEncoder.matches(request.getPassword(), member.get().getPassword())) {
            return LoginResDto.fromDto(member.get());
        }
        else {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }

}
