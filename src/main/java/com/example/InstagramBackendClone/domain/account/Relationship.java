package com.example.InstagramBackendClone.domain.account;

import com.example.InstagramBackendClone.domain.base.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Relationship extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private Account follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id")
    private Account following;

}
