package org.example.domain.account.controller;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.example.domain.member.repository.MemberRepository;
import org.example.domain.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthRequest authRequest) {
        String body = memberService.login(authRequest.getEmail(), authRequest.getPassword());
        System.out.println(">> body >> " + body);
        if(body == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
