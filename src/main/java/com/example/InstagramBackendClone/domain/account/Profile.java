package com.example.InstagramBackendClone.domain.account;

import com.example.InstagramBackendClone.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Account account;

    private String original_file_name;

    private String stored_file_path;

    private long file_size;

    @Builder
    private Profile(Account account){
        this.account = account;
    }

    public void ChangeProfileImage(String fileName, String filePath, Long file_size){

    }

}
