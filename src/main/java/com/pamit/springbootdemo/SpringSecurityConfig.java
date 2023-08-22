package com.pamit.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// This is to disable CSRF for CURL POST
// curl -i -XPOST http://localhost:8080/students -H 'Content-Type: application/json' -d '{"firstName":"P1", "email":"e1"}' -u "user:67ffac77-5
//a43-4bee-a759-7ca10032d79d"
@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // Credentials window
        httpSecurity.httpBasic(Customizer.withDefaults());

        // For POST/PUT
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
