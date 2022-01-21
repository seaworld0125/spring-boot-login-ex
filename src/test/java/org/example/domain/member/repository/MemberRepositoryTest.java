package org.example.domain.member.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.factory.EntityFactory;
import org.example.domain.member.model.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void save() {
        MemberEntity memberEntity = memberRepository.save(EntityFactory.createNormalMemberEntity());

        assertEquals(memberEntity.getPassword(), EntityFactory.testPassword);
    }

    @Test
    public void find() {
        MemberEntity memberEntity = memberRepository.save(EntityFactory.createNormalMemberEntity());

        MemberEntity savedEntity = memberRepository.findMemberEntityByName(EntityFactory.testName)
                                                .orElse(EntityFactory.createNullMemberEntity());

        assertEquals(memberEntity.getName(), savedEntity.getName());
    }
}