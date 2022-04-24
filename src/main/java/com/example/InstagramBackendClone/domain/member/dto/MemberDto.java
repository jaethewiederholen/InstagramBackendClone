package com.example.InstagramBackendClone.domain.member.dto;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String email;
    private List<Account> accounts;

    public MemberDto(Member member){
        this.id = member.getId();
        this.email = member.getEmail();
    }
}
