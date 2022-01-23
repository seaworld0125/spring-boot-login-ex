package org.example.domain.member.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.core.auth.JwtUtil;
import org.example.domain.member.model.Member;
import org.example.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findMemberByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public String login(String email, String password) {
        Member member = (Member) loadUserByUsername(email);

        if(passwordEncoder.matches(password, member.getPassword())) {
            return JwtUtil.createAuthToken(email);
        }
        return null;
    }
}
