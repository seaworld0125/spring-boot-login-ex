package org.example.domain.account.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@WebMvcTest
class SignControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. 로그인 테스트")
    @Test
    void login() throws Exception {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();

        data.add("email", "tester");
        data.add("password", "1234");

    }
}