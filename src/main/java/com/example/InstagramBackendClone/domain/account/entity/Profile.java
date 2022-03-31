package com.example.InstagramBackendClone.domain.account.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    private Account account;

    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getOriginal_file_name() {
        return original_file_name;
    }

    public String getStored_file_path() {
        return stored_file_path;
    }

    public long getFile_size() {
        return file_size;
    }
}
