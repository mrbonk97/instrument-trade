package com.mrbonk.instrumenttrade.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    @OneToOne
    private Image profileImage;
    private Boolean emailVerified = false;
    private Role role = Role.ROLE_USER;
    private Provider provider = Provider.LOCAL;
    private String providerId;
    @OneToMany
    private List<Post> myPost;
    @OneToMany
    private List<Post> likedPost;
    @OneToMany
    private List<Comment> myComment;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
