package com.mrbonk.instrumenttrade.request.post;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostCreateRequest {
    private String title;
    private String description;
    private List<String> imageList;
    private String category;
}
