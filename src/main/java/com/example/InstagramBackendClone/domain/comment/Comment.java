package com.example.InstagramBackendClone.domain.comment;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.base.BaseEntity;
import com.example.InstagramBackendClone.domain.post.Post;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<CommentLike> likes = new ArrayList<CommentLike>();

    @Column(length = 1000)
    @NotBlank
    private String content;
}
