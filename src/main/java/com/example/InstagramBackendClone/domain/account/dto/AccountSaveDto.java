package com.example.InstagramBackendClone.domain.account.dto;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.member.MemberRepository;
import com.example.InstagramBackendClone.service.member.MemberService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(description = "계정 생성 DTO")
@Getter
@NoArgsConstructor
public class AccountSaveDto {
    @Schema(description = "유저 id", nullable = false, example = "1")
    private Long memberId;

    @Schema(description = "이름", nullable = false, example = "길동계정")
    private String name;

    @Schema(description = "생년월일", nullable = true, example = "1998-05-07")
    private String birthDate;

    @Builder
    public AccountSaveDto(Long memberId, String name, String birthdate) {
        this.memberId = memberId;
        this.name = name;
        this.birthDate = birthdate;
    }

}
