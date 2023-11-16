package com.mrbonk.instrumenttrade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Post post;
    String text;
    @ManyToOne
    User user;

}
