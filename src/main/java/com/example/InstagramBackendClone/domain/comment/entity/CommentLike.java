package com.example.InstagramBackendClone.domain.comment.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
