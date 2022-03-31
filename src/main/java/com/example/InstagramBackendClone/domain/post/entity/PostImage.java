package com.example.InstagramBackendClone.domain.post.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="post")
    private Post post;

    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public String getOriginal_file_name() {
        return original_file_name;
    }

    public String getStored_file_path() {
        return stored_file_path;
    }

    public long getFile_size() {
        return file_size;
    }
}
