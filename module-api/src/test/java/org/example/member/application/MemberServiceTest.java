package org.example.member.application;


import org.assertj.core.api.Assertions;
import org.example.member.domain.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private  MemberService memberService;



    @DisplayName("module api Test")
    @Test
    void saveAnyMember() {

        Member member = Member.builder().name("nobody").build();

        Long id = memberService.signup(member);


        Assertions.assertThat(id).isEqualTo(1L);


    }

    @Test
    void findAnyMember() {
    }
}