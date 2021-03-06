package com.example.InstagramBackendClone.domain.tag;

import com.example.InstagramBackendClone.domain.base.BaseEntity;
import com.example.InstagramBackendClone.domain.post.PostTag;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    @NotBlank
    private List<PostTag> postTags = new ArrayList<PostTag>();

}
