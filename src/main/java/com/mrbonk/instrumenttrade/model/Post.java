package com.mrbonk.instrumenttrade.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String description;
    String category;
    @OneToMany
    List<Image> imageList;
    @OneToMany
    List<Comment> commentList;
    @ManyToOne
    User originalPoster;

    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
