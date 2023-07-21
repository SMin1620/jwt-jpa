package com.jwt.jwt.member.dto.login;

import com.jwt.jwt.authentication.TokenProvider;
import com.jwt.jwt.member.dto.register.RegisterResDto;
import com.jwt.jwt.member.entity.Member;
import com.jwt.jwt.token.Token;
import com.jwt.jwt.token.TokenDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {

    @Schema(description = "회원 고유키", example = "1")
    Long id;

    @Schema(description = "회원 이메일", example = "email@email.com")
    String email;

    @Schema(description = "회원 이름", example = "짱구")
    String nickname;

    @Schema(description = "회원 나이", example = "5")
    Integer age;

//    private String accessToken;

    // 토큰 Dto
    private TokenDto token;

    public static LoginResDto fromDto(Member member, TokenProvider tokenProvider) {
        return new LoginResDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getAge(),

                // payload 에 집어넣을 데이터, 토큰 생성
                TokenDto.builder()
                        .access_token(tokenProvider.createToken(member.getEmail(), member.getNickname(), member.getRole()))
                        .refresh_token(member.getRefreshToken())
                        .build()
        );
    }
}
