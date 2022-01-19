package org.example.domain.member.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MemberDto {

    private String name;
    private String password;

    @Builder
    public MemberDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
