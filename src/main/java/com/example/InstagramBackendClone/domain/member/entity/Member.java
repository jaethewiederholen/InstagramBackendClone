package com.example.InstagramBackendClone.domain.member.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();

}
