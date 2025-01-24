package com.kht.ecommerce_application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.AuthProvider;

@Configuration
public class SecurityConfig {
    //비밀번호 암호화 처리하는 자바기능 불러와서
    // Bean 설정하여 스프링부트 자체에서 사용자가 작성한 비밀번호를
    // 암호화 처리하여 저장할 수 있도록 설정
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .formLogin(form -> form.disable());
        return http.build(); // build = 빌딩  위에서 작성한 http 속성으로 뭉쳐놓은 다음 사용
    }
}
