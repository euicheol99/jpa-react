package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.User;
import lombok.*;

public class UserDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{

        private String user_id;
        private String password;
        private String email;
        private String name;

        public User toEntity() {
            return User.builder()
                    .userId(this.user_id)
                    .password(this.password)
                    .email(this.email)
                    .name(this.name)
                    .build();
        }
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{

        private String user_id;
        private String password;
        private String name;
        private String email;

        public static Response toDto(User user) {
            return Response.builder()
                        .user_id(user.getUserId())
                        .password(user.getPassword())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build();
        }
    }
}
