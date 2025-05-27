package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Post;
import com.kh.reactbackend.repository.MemberRepository;
import com.kh.reactbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    public Post createPost(PostDto.Create createDto){
        Member member =memberRepository.findMember(createDto.getMember_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = createDto.toEntity();
        post.changeMember(member);
        postRepository.save(post);

        return post;
    }

    @Override
    public Page<PostDto.Response> getPostList(Pageable pageable) {
        Page<Post> page = postRepository.getPosts(pageable);
        return page.map(PostDto.Response::toSimpleDto);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deletePost(id);
    }


}
