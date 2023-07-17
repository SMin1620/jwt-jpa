package com.jwt.jwt.domain.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    @Schema(description = "이메일", example = "user@email.com", defaultValue = "")
    private String email;

    @Column(length = 100, nullable = false)
    @Schema(description = "비밀번호", example = "qwe123@")
    private String password;

    @Column(length = 100, nullable = false, unique = true)
    private String nickName;

    private LocalDateTime memberDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public static Member createMember(MemberReqDto memberReqDto) {
        Member member = new Member();

        member.setEmail(memberReqDto.getEmail());
        member.setPassword(memberReqDto.getPassword());
        member.setNickName(memberReqDto.getNickName());
        member.setMemberDate(LocalDateTime.now());
        member.setRole(Role.USER);

        return member;
    }

    // 비밀번호 검사 로직
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
