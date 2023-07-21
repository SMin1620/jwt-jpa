package com.jwt.jwt.member.entity;

import com.jwt.jwt.common.Role;
import com.jwt.jwt.member.dto.register.RegisterReqDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    // 리프레시 토큰
    private String refreshToken;


    /**
     * 회원 가입 로직
     */
    public static Member fromEntity(RegisterReqDto request, PasswordEncoder encoder) {
        return Member.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .age(request.getAge())
                .role(Role.USER)
                .createAt(LocalDateTime.now())
                .build();
    }

    /**
     * 회원가입 :: 비밀번호 암호화 적용
     */


    /**
     * 리프레시 토큰
     */
    public void setRefreshToken(String refreshToken) { // 추가!
        this.refreshToken = refreshToken;
    }
}
