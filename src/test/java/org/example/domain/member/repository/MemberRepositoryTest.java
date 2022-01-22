package org.example.domain.member.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;
import org.example.core.auth.Authority;
import org.example.domain.factory.EntityFactory;
import org.example.domain.member.model.Member;
import org.example.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @DisplayName("1. 멤버의 정상 생성 확인")
    @Test
    public void addAuthority() {
        memberRepository.save(EntityFactory.createNormalMemberEntity());

        Member savedMember = memberRepository.findMemberEntityByName(EntityFactory.testName)
                .orElse(EntityFactory.createNullMemberEntity());

        assertEquals(savedMember.getAuthority(), Authority.ROLE_USER);
    }
}