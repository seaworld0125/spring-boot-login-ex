package org.example.domain.member.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberMapperTest {

    @Mock
    MemberMapper memberMapper;

    @Test
    void memberDtoToMemberTest() {
        MemberDto memberDto = new MemberDto("newMember", "9999");

        MemberEntity memberEntity = memberMapper.INSTANCE.memberDtoToMember(memberDto);
        assertEquals(memberEntity.getName(), memberDto.getName());
        assertEquals(memberEntity.getPassword(), memberDto.getPassword());
    }
}