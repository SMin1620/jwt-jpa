package com.jwt.jwt.member.contoller;

import com.jwt.jwt.common.BaseResponse;
import com.jwt.jwt.member.dto.login.LoginReqDto;
import com.jwt.jwt.member.dto.register.RegisterReqDto;
import com.jwt.jwt.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Tag(name = "회원 API")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 가입")
    @PostMapping("/register")
    public BaseResponse register(
            @RequestBody RegisterReqDto request
    ) {
        return BaseResponse.success(memberService.register(request));
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public BaseResponse login(
            @RequestBody LoginReqDto request
    ) {
        return BaseResponse.success(memberService.login(request));
    }
}
