package com.jwt.jwt.dto;

import com.jwt.jwt.model.Member;
import com.jwt.jwt.model.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberReqDto {


    @NotEmpty(message = "이메일은 필수 입력입니다.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @NotEmpty(message = "닉네임는 필수 입력입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
    private String nickName;

    /* DTO -> Entity */
    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .role(Role.USER)
                .memberDate(LocalDateTime.now())
                .build();
    }




}
