package org.example.domain.member.model;

import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {

    private Long memberId;
    private String name;
    private String password;

    private String authority;

}
