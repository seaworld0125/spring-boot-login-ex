package org.example.domain.factory;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.example.domain.member.model.MemberEntity;

public class EntityFactory {

    public static final String testName = "tester";
    public static final String testPassword = "1234";

    public static MemberEntity createMemberEntity() {
        return MemberEntity.builder()
                .name(testName)
                .password(testPassword)
                .build();
    }
}
