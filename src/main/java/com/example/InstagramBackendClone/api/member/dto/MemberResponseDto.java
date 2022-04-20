package com.example.InstagramBackendClone.api.member.dto;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String email;
    //private List<Account> accounts;

    public MemberResponseDto(Member entity){
        this.id = entity.getId();;
        this.email = entity.getEmail();
        //this.accounts = entity.getAccounts();
    }
}
