package com.kh.reactbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class User {

    @Id
    @Column(name = "USER_ID", length = 30)
    private String userId;

    @Column(name = "PASSWORD", length=20)
    private String password;

    @Column(name = "NAME", length = 21)
    private String name;

    @Column(name = "EMAIL", length = 30)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

}
