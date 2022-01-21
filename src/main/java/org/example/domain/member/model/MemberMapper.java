package org.example.domain.member.model;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberEntity memberDtoToMember(MemberDto memberDto);

    MemberDto memberToMemberDto(MemberEntity memberEntity);
}
