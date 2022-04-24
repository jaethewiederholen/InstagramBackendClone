package com.example.InstagramBackendClone.domain.member.dto;

import com.example.InstagramBackendClone.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "회원가입 DTO")
@Getter
@NoArgsConstructor
public class MemberSaveDto {
    @Schema(description = "이메일", nullable = false, example = "abc@example.com")
    private String email;

    @Schema(description = "비밀번호", nullable = true)
    private String password;

    @Builder
    public MemberSaveDto(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Member ToEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
