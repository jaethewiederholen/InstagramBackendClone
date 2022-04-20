package com.example.InstagramBackendClone.api.member.dto;

import com.example.InstagramBackendClone.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberListResponseDto {
    private Long id;
    private String email;

    public MemberListResponseDto(Member entity){
        this.id = entity.getId();;
        this.email = entity.getEmail();
    }
}
