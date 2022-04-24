package com.example.InstagramBackendClone.service.member;

import com.example.InstagramBackendClone.domain.member.dto.MemberResponseDto;
import com.example.InstagramBackendClone.domain.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.domain.member.dto.MemberSaveResponseDto;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public HashMap<String, Object> save(MemberSaveDto memberSaveDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Member member = memberRepository.save(memberSaveDto.ToEntity());
        result.put("id", member.getId());

        return result;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 유저가 없습니다. id=" + id));
        System.out.println(member.getAccounts());
        return new MemberResponseDto(member);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAllDesc(){
        return memberRepository.findAllDesc().stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }


}
