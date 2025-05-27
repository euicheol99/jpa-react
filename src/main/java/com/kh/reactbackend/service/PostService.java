package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Post createPost(PostDto.Create create);
    Page<PostDto.Response> getPostList(Pageable pageable);
    void deletePost(Long id);
}
