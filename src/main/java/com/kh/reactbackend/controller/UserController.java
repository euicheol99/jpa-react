package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.UserDto;
import com.kh.reactbackend.entity.User;
import com.kh.reactbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto.Create userDto) {
        User user = userService.createUser(userDto);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto.Response> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.findUser(userId));
    }
}
