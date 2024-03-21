package com.example.springbootvue.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity          // springsecurity 활성화, 웹 보안 설정 구성
@Configuration              // Bean 등록
@RequiredArgsConstructor    // 필드의 생성자를 자동으로 생성
public class WebSecurityConfig extends WebSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
            BCryptPasswordEncoder
            비밀번호를 암호화(해시)
            솔트(salt)를 부여하여 여러 번 해싱한다.
         */
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http.build();
    }

}
