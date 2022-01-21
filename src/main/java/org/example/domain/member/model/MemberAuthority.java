package org.example.domain.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@IdClass(MemberAuthority.class)
public class MemberAuthority implements GrantedAuthority {

    @Id
    @Column(nullable = false)
    private Long memberId;

    @Id
    @Column(nullable = false)
    private String authority;
}
