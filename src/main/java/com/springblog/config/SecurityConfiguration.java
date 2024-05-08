package com.springblog.config;

import com.springblog.service.Oauth2MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final Oauth2MemberService oauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .formLogin(login -> login.loginPage("/member/login"))
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .permitAll()
                )
                // OAuth2 로그인 구성을 위한 설정 가져옴
                .oauth2Login(oauth2 -> oauth2
                        // 사용자 정보 엔드포인트에 대한 설정 추가
                        .userInfoEndpoint(infoEndpoint ->
                                // 사용자 서비스 구성(로그인 성공 후 사용자 정보 처리)
                                infoEndpoint.userService(oauth2UserService)));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
