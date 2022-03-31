package com.example.InstagramBackendClone.domain.post.entity;

import com.example.InstagramBackendClone.domain.tag.entity.Tag;

import javax.persistence.*;

@Entity
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public Tag getTag() {
        return tag;
    }
}
