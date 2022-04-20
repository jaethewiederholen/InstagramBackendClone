package com.example.InstagramBackendClone.api.member;

import com.example.InstagramBackendClone.api.member.dto.MemberResponseDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveResponseDto;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.member.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.minidev.json.JSONObject;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void clear() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void 회원가입() throws Exception{
        //given
        String email = "ex1@example.com";
        String password = "1234";

        MemberSaveDto memberSaveDto = MemberSaveDto.builder()
                .email(email)
                .password(password)
                .build();
        String url = "http://localhost:" + port + "/v1/api/member";

        //when
        ResponseEntity<MemberSaveResponseDto> responseEntity = restTemplate.postForEntity(
                url, memberSaveDto, MemberSaveResponseDto.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getPassword()).isEqualTo(password);

    }

    @Test
    public void 특정회원조회() throws Exception{
        //given
        String email = "ex1@example.com";
        String password = "12345";

        Member member = memberRepository.save(Member.builder()
                .email(email)
                .password(password)
                .build());
        Long id = member.getId();

        String url = "http://localhost:" + port + "/v1/api/member/" + id;

        //when
        ResponseEntity<MemberResponseDto> responseEntity = restTemplate.getForEntity(url, MemberResponseDto.class);
        //then
        assertThat(responseEntity.getBody().getId()).isEqualTo(id);
    }
}