package com.example.InstagramBackendClone.domain.post;

import com.example.InstagramBackendClone.domain.base.BaseEntity;
import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.comment.Comment;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(length = 5000)
    private String context;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<PostImage> images = new ArrayList<PostImage>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTag> tags = new ArrayList<PostTag>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostLike> likes = new ArrayList<PostLike>();

}
