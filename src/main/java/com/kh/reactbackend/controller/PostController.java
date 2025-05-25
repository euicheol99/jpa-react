package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;
import com.kh.reactbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto.Create postDto){
        Post post = postService.createPost(postDto);
        return ResponseEntity.ok(post);
    }
}
