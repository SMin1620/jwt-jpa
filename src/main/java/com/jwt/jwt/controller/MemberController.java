package com.jwt.jwt.controller;

import com.jwt.jwt.domain.member.Member;
import com.jwt.jwt.domain.member.MemberReqDto;
import com.jwt.jwt.service.MemberService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@Slf4j
@Tag(name = "user", description = "사용자 API")
public class MemberController {

    private final MemberService memberService;


//    @PostMapping("/register")
//    @Operation(summary = "회원 가입", description = "이메일, 비밀번호, 닉네임으로 회원가입 진행")
//    public ResponseEntity<Long> register(
//            @RequestBody @Valid MemberReqDto request
//            )
//    {
//        Long memberId = memberService.register(request);
//        log.info("회원가입 성공 !!");
//
//        return ResponseEntity.ok().body(memberId);
//    }

    @PostMapping("/register")
    @Operation(summary = "회원 가입", description = "이메일, 비밀번호, 닉네임으로 회원가입 진행")
    public BaseResponse register(
            @RequestBody MemberReqDto request
    )
    {
        BaseResponse response = null;

        try {
            Member member = memberService.register(request);

            response = new BaseResponse("success", "회원 가입 성공", member);
        } catch(IllegalStateException e) {
            response = new BaseResponse("fail", "회원 가입 실패", e.getMessage());
        }
        return response;
    }

}
