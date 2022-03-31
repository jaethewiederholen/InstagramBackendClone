package com.example.InstagramBackendClone.domain.comment.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;

import javax.persistence.*;

@Entity
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Comment getComment() {
        return comment;
    }
}
