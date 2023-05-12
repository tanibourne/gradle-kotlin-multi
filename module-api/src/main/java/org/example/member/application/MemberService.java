package org.example.member.application;

import lombok.RequiredArgsConstructor;
import org.example.member.domain.Member;
import org.example.member.domain.MemberRepository;
import org.example.member.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public void saveAnyMember() {
        memberRepository.save(Member.builder().name("nobody").build());
    }

    public Long signup (Member member) {
        return memberRepository.save(member).getId();
    }
    public Member findAnyMember() {
        return memberRepository.findById(1L).get();
    }
}
