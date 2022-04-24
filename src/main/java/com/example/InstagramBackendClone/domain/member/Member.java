package com.example.InstagramBackendClone.domain.member;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
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

    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    @Builder
    private Member(String email, String password){
        this.email = email;
        this.password= password;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setMember(this);
    }

    @JsonProperty("accounts")
    public List<String> getAccounts() {
        return accounts.stream().map(Account::getName).collect(Collectors.toList());
    }



}
