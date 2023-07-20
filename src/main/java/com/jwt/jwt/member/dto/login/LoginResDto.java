package com.jwt.jwt.member.dto.login;

import com.jwt.jwt.member.dto.register.RegisterResDto;
import com.jwt.jwt.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResDto {

    @Schema(description = "회원 고유키", example = "1")
    Long id;

    @Schema(description = "회원 이메일", example = "email@email.com")
    String email;

    @Schema(description = "회원 이름", example = "짱구")
    String nickname;

    @Schema(description = "회원 나이", example = "5")
    Integer age;

    public static LoginResDto fromDto(Member member) {
        return new LoginResDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getAge()
        );
    }
}
