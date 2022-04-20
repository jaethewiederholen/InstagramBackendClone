package com.example.InstagramBackendClone.domain.account;

import com.example.InstagramBackendClone.domain.base.BaseEntity;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotBlank
    @Column(length = 50, unique = true)
    private String name;

    @Column(length = 100)
    private String bio;

    private LocalDate birthDate;

    //private profile image one to one
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Profile profile;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<Post>();


    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private List<Relationship> followings = new ArrayList<Relationship>();

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Relationship> followers = new ArrayList<Relationship>();
}
