package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class PostRepositoryImpl implements PostRepository{

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Post post) { em.persist(post);}

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        String query = "select p from Post as p" ;
        List<Post> posts = em.createQuery(query, Post.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        String countQuery = "select count(p) from Post as p" ;
        Long totalCount = em.createQuery(countQuery, Long.class)
                .getSingleResult();
        return new PageImpl<Post>(posts, pageable, totalCount);
    }

    @Override
    public void deletePost(Long id) {
        em.remove(em.find(Post.class, id));
    }


}
