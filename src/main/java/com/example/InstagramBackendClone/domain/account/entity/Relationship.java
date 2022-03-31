package com.example.InstagramBackendClone.domain.account.entity;

import com.example.InstagramBackendClone.domain.account.entity.Account;
import com.example.InstagramBackendClone.domain.base.entity.BaseEntity;

import javax.persistence.*;

@Entity
public class Relationship extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Account follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private Account following;

    public Long getId() {
        return id;
    }

    public Account getFollower() {
        return follower;
    }

    public Account getFollowing() {
        return following;
    }
}
