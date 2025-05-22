package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.UserDto;
import com.kh.reactbackend.entity.User;

public interface UserService {
    User createUser(UserDto.Create userDto);
    UserDto.Response findUser(String userId);
}
