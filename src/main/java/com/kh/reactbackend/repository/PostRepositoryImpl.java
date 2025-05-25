package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class PostRepositoryImpl implements PostRepository{

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Post post) { em.persist(post);}
}
