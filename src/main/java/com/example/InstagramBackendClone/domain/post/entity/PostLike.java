package com.example.InstagramBackendClone.domain.post.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;

import javax.persistence.*;

@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public Account getAccount() {
        return account;
    }
}
