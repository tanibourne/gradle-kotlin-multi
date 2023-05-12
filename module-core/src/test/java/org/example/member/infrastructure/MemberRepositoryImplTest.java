package org.example.member.infrastructure;

import org.example.member.domain.Member;
import org.example.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class MemberRepositoryImplTest {

    @Autowired
    private  MemberRepository memberRepository;



    @DisplayName("core module Test")
    @Test
    void save() {

        memberRepository.save(Member.builder().name("nononon").build());
        Optional<Member> saved = memberRepository.findById(1L);


        Assertions.assertThat(saved.get().getName()).isEqualTo("nononon");

    }
}