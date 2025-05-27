package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepository {
    void save(Post post);
    Page<Post> getPosts(Pageable pageable);
    void deletePost(Long id);
}
