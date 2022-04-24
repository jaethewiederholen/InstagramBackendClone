package com.example.InstagramBackendClone.domain.member;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m from Member m ORDER BY m.id DESC")
    List<Member> findAllDesc();

}