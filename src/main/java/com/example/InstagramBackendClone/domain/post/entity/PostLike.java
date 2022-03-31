package com.example.InstagramBackendClone.domain.post.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;

}
