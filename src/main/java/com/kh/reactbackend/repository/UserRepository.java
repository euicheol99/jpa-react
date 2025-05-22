package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findUser(String userId);

}
