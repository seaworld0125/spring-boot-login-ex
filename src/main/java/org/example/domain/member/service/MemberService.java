package org.example.domain.member.service;

import lombok.Builder;
import org.example.core.auth.Authority;
import org.example.domain.member.model.MemberAuthority;
import org.example.domain.member.model.MemberEntity;
import org.example.domain.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Builder
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findMemberEntityByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public MemberEntity save(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    public void addAuthority(Long memberId, String authority) {
        memberRepository.findById(memberId).ifPresent(memberEntity -> {
            MemberAuthority newRole = MemberAuthority.builder().memberId(memberId).authority(authority).build();

            if(!memberEntity.getAuthorities().contains(newRole)) {
                memberEntity.getAuthorities().add(newRole);
                save(memberEntity);
            }
        });
    }
}
