package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.PageResponse;
import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;
import com.kh.reactbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<PageResponse<PostDto.Response>> getAllPosts(@PageableDefault(size = 10, sort = "createDate",
                                                    direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(new PageResponse<>(postService.getPostList(pageable)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto.Response> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}
