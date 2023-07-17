package com.jwt.jwt.domain.member;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "회원 요청 DTO")
public class MemberResDto {

    private Long id;
    private String email;
    private String password;
    private String nickName;
    private LocalDateTime memberDate;
    private Role role;

    // DTO -> Entity
    public MemberResDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.nickName = member.getNickName();
        this.role = member.getRole();
    }
}
