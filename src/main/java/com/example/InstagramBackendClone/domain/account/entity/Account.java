package com.example.InstagramBackendClone.domain.account.entity;

import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;
import com.example.InstagramBackendClone.domain.member.entity.Member;
import com.example.InstagramBackendClone.domain.post.entity.Post;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @NotBlank
    @Column(length = 50, unique = true)
    private String name;

    @Column(length = 100)
    private String bio;

    private LocalDate birthDate;

    //private profile image one to one
    @OneToOne
    @JoinColumn(name="account_id")
    private Profile profile;

    @OneToMany(mappedBy = "account")
    private List<Post> posts = new ArrayList<Post>();


    @OneToMany(mappedBy = "following")
    private List<Relationship> followings = new ArrayList<Relationship>();

    @OneToMany(mappedBy = "follower")
    private List<Relationship> followers = new ArrayList<Relationship>();

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Relationship> getFollowings() {
        return followings;
    }

    public List<Relationship> getFollowers() {
        return followers;
    }
}
