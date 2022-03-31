package com.example.InstagramBackendClone.domain.post.entity;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post")
    private Post post;

    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;
}
