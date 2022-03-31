package com.example.InstagramBackendClone.domain.tag.entity;

import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;
import com.example.InstagramBackendClone.domain.post.entity.PostTag;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @OneToMany(mappedBy = "tag")
    @NotBlank
    private List<PostTag> postTags = new ArrayList<PostTag>();

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
