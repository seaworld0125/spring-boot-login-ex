package org.example.domain.member.service;

import lombok.Builder;
import org.example.domain.member.model.Member;
import org.example.domain.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
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

    public Member save(Member member) {
        return memberRepository.save(member);
    }
    /*
    public void addAuthority(Long memberId, String authority) {
        memberRepository.findById(memberId).ifPresent(member -> {
            MemberAuthority newRole = MemberAuthority.builder().memberId(memberId)
                    .authority(authority).build();

            if (!member.getAuthorities().contains(newRole)) {
                member.getAuthorities().add(newRole);
                save(member);
            }
        });
    }

    public void removeAuthority(Long memberId, String authority) {
        memberRepository.findById(memberId).ifPresent(member -> {
            if (member.getAuthorities() == null) {
                return;
            }
            MemberAuthority targetRole = MemberAuthority.builder().memberId(memberId)
                    .authority(authority).build();
            if(member.getAuthorities().contains(targetRole)) {
                member.getAuthorities().remove(targetRole);
                save(member);
            }
        });
    }
    */
}
