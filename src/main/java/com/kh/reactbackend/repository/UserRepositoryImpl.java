package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public Optional<User> findUser(String userId) {
        return Optional.ofNullable(em.find(User.class, userId));
    }
}
