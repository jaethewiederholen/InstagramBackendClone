package com.example.InstagramBackendClone.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanup(){
        memberRepository.deleteAll();}

    @Test
    public void 멤버_등록() {
        //given
        String email = "ex1@example.com";
        String password = "12345";

        memberRepository.save(Member.builder()
                .email(email)
                .password(password)
                .build());

        //when
        List<Member> memberList = memberRepository.findAll();
        //then
        Member member = memberList.get(0);
        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getPassword()).isEqualTo(password);
    }

    @Test
    public void 이메일_중복_불가() {
        //given
        String email = "ex1@example.com";
        String password = "12345";

        memberRepository.save(Member.builder()
                .email(email)
                .password(password)
                .build());

        //when
        String email1 = "ex1@example.com";
        String password1 = "12345";

        //then
        DataIntegrityViolationException e = assertThrows(DataIntegrityViolationException.class,
                () -> memberRepository.save(Member.builder()
                        .email(email1)
                        .password(password1)
                        .build()));

    }
}