package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findMember(String memberId) {
        return Optional.ofNullable(em.find(Member.class, memberId));
    }
}
