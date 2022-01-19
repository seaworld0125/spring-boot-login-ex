package org.example.domain.member.model;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "password")
    MemberEntity memberDtoToMember(MemberDto memberDto);
}
