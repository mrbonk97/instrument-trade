package com.mrbonk.instrumenttrade.controller;

import com.mrbonk.instrumenttrade.dto.Response;
import com.mrbonk.instrumenttrade.model.Post;
import com.mrbonk.instrumenttrade.request.post.PostCreateRequest;
import com.mrbonk.instrumenttrade.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public Response<Post> createPost(Authentication authentication, @RequestBody PostCreateRequest postCreateRequest) {
        // public Post createPost(Long userId, String title, String description, String category, List<String> imageList) {
        Long userId = Long.valueOf(authentication.getName());
        Post post = postService.createPost(userId, postCreateRequest.getTitle(), postCreateRequest.getDescription(), postCreateRequest.getCategory(), postCreateRequest.getImageList());
        return Response.success(post);
    }

    @GetMapping("/{postId}")
    public Response<Post> createPost(@PathVariable Long postId) {
        Post post = postService.getSinglePost(postId);
        return Response.success(post);
    }

}
