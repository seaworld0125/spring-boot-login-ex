package org.example.domain.member.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
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
        MemberDto memberDto = MemberDto.builder()
                .name("test")
                .password("1111")
                .build();

        MemberEntity memberEntity = memberMapper.INSTANCE.memberDtoToMember(memberDto);
        assertEquals(memberEntity.getName(), memberDto.getName());
        assertEquals(memberEntity.getPassword(), memberDto.getPassword());
    }
}