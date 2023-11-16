package com.mrbonk.instrumenttrade.service;

import com.mrbonk.instrumenttrade.model.Post;
import com.mrbonk.instrumenttrade.model.User;
import com.mrbonk.instrumenttrade.repository.PostRepository;
import com.mrbonk.instrumenttrade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Long userId, String title, String description, String category, List<String> imageList) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("ASD"));
        Post post = new Post();
        post.setOriginalPoster(user);
        post.setTitle(title);
        post.setDescription(description);

        return postRepository.save(post);
    }

    public Post updatePost(Long userId, Long postId, String title, String description, String category, List<String> imageList) throws IOException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("그런거 없따"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("ASD"));
        if(post.getOriginalPoster() != user) throw new RuntimeException("매칭이 안된다");

        post.setTitle(title);
        post.setDescription(description);
        post.setCategory(category);

        return postRepository.saveAndFlush(post);
    }

    public void deleteMemory(Long userId, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("그런거 없따"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("ASD"));
        if(post.getOriginalPoster() != user) throw new RuntimeException("매칭이 안된다");

        postRepository.deleteById(postId);
    }

    public Post getSinglePost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new RuntimeException("포스트 없음"));
    }
}

