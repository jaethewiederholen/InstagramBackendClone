package com.example.InstagramBackendClone.domain.post;

import com.example.InstagramBackendClone.domain.tag.Tag;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
