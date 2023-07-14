package com.jwt.jwt.controller;

import com.jwt.jwt.dto.MemberReqDto;
import com.jwt.jwt.dto.MemberResDto;
import com.jwt.jwt.model.Member;
import com.jwt.jwt.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/register")
    public ResponseEntity<Long> register(
            @RequestBody @Valid MemberReqDto request
            )
    {
        Long memberId = memberService.register(request);
        log.info("회원가입 성공 !!");

        return ResponseEntity.ok().body(memberId);
    }

}
