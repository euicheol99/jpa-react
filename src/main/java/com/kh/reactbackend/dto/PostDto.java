package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Post;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class PostDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{


        private String stack;
        private String content;
        private String member_id;

        public Post toEntity() {
            return Post.builder()
                    .stack(this.stack)
                    .content(this.content)
                    .build();
        }
    }
}
