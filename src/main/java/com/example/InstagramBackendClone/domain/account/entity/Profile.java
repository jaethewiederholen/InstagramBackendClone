package com.example.InstagramBackendClone.domain.account.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private Account account;

    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;

}
