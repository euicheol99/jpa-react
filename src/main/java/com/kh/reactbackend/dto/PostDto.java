package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Comment;
import com.kh.reactbackend.entity.Post;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{

        private String post_title;
        private String stack;
        private String content;
        private String member_id;

        public Post toEntity() {
            return Post.builder()
                    .postTitle(this.post_title)
                    .stack(this.stack)
                    .content(this.content)
                    .createDate(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long post_id;
        private String stack;
        private String post_title;
        private String member_id;
        private String content;
        private LocalDateTime created_date;
        private List<Comment> comments = new ArrayList<>();

        public static Response toSimpleDto(Post post) {
            return Response.builder()
                    .post_id(post.getPostId())
                    .stack(post.getStack())
                    .post_title(post.getPostTitle())
                    .member_id(post.getMember().getMemberId())
                    .build();
        }
    }
}
