package com.example.InstagramBackendClone.domain.comment.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "comment")
    private List<CommentLike> likes = new ArrayList<CommentLike>();

    @Column(length = 1000)
    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getContent() {
        return content;
    }

    public List<CommentLike> getLikes() {
        return likes;
    }
}
