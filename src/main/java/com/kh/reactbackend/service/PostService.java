package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;

public interface PostService {
    Post createPost(PostDto.Create create);
}
