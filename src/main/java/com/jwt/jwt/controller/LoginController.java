package com.jwt.jwt.controller;

import com.jwt.jwt.domain.member.Member;
import com.jwt.jwt.domain.member.MemberReqDto;
import com.jwt.jwt.repository.MemberRepository;
import com.jwt.jwt.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
@RequestMapping("/api/v1")
@Slf4j
@Tag(name = "user", description = "사용자 인증 API")
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/login")
    @Operation(description = "회원 로그인")
    public ResponseEntity<Map<String, Object>> login (
            @RequestBody MemberReqDto memberReqDto) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            Member memberInfo = memberService.login(memberReqDto.getEmail(), memberReqDto.getPassword());

            status = HttpStatus.OK;
            resultMap.put("user", memberInfo);
        } catch (Exception e) {
            log.error("로그인 실패 : {}", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            resultMap.put("message", e.getMessage());
        }

        return new ResponseEntity<Map<String, Object>>(resultMap, status);

    }


}
