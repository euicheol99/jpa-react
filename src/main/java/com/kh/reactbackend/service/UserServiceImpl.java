package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.UserDto;
import com.kh.reactbackend.entity.User;
import com.kh.reactbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserDto.Create userDto) {
        User user = userDto.toEntity();
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDto.Response findUser(String userId) {

        return userRepository.findUser(userId)
                .map(UserDto.Response::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
