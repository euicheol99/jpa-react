package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(MemberDto.Create memberDto) {
        Member member = memberDto.toEntity();
        memberRepository.save(member);
        return member;
    }

    @Override
    public MemberDto.Response findMember(String memberId) {

        return memberRepository.findMember(memberId)
                .map(MemberDto.Response::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public MemberDto.Response loginMember(String memberId, String password) {
        return memberRepository.loginMember(memberId,password)
                .map(MemberDto.Response::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
