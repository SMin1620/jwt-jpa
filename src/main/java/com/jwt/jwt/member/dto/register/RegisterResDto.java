package com.jwt.jwt.member.dto.register;

import com.jwt.jwt.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

//public record RegisterResDto(
//        @Schema(description = "회원 고유키", example = "1")
//        Long id,
//        @Schema(description = "회원 이메일", example = "email@email.com")
//        String email,
//        @Schema(description = "회원 이름", example = "짱구")
//        String nickname,
//        @Schema(description = "회원 나이", example = "5")
//        Integer age
//) {
//
//    public static RegisterResDto fromDto(Member member) {
//        return new RegisterResDto(
//                member.getId(),
//                member.getEmail(),
//                member.getNickname(),
//                member.getAge()
//        );
//    }
//}

@Data
@Builder
public class RegisterResDto {

    @Schema(description = "회원 고유키", example = "1")
    Long id;

    @Schema(description = "회원 이메일", example = "email@email.com")
    String email;

    @Schema(description = "회원 이름", example = "짱구")
    String nickname;

    @Schema(description = "회원 나이", example = "5")
    Integer age;

    public static RegisterResDto fromDto(Member member) {
        return new RegisterResDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getAge()
        );
    }

}