package com.example.InstagramBackendClone.service.member;

import com.example.InstagramBackendClone.api.member.dto.MemberListResponseDto;
import com.example.InstagramBackendClone.api.member.dto.MemberResponseDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveResponseDto;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto save(MemberSaveDto memberSaveDto) {
        MemberSaveResponseDto result = new MemberSaveResponseDto(memberRepository.save(memberSaveDto.ToEntity()));
        return result;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id){
        Member entity = memberRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 유저가 없습니다. id=" + id));
        return new MemberResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAllDesc(){
        return memberRepository.findAllDesc().stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }


}
