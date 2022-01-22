package org.example.domain.factory;

import org.example.core.auth.Authority;
import org.example.domain.member.model.Member;

public class EntityFactory {

    public static final String testName = "tester";
    public static final String testPassword = "1234";

    public static Member createNormalMemberEntity() {
        return Member.builder()
                .name(testName)
                .password(testPassword)
                .authority(Authority.ROLE_USER)
                .build();
    }
    public static Member createNullMemberEntity() {
        return Member.builder()
                .name("")
                .password("")
                .authority("")
                .build();
    }
}
