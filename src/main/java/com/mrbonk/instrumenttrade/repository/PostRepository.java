package com.mrbonk.instrumenttrade.repository;

import com.mrbonk.instrumenttrade.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
