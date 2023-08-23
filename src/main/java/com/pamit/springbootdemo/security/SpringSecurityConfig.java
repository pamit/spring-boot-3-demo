package com.pamit.springbootdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Authorization roles
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/api/employees", HttpMethod.GET.name())).hasRole("EMPLOYEE")
                .requestMatchers(new AntPathRequestMatcher("/api/employees/**", HttpMethod.GET.name())).hasRole("EMPLOYEE")
                .requestMatchers(new AntPathRequestMatcher("/api/employees", HttpMethod.POST.name())).hasRole("MANAGER")
                .requestMatchers(new AntPathRequestMatcher("/api/employees", HttpMethod.PUT.name())).hasRole("MANAGER")
                .requestMatchers(new AntPathRequestMatcher("/api/employees", HttpMethod.DELETE.name())).hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        // Credentials window
        httpSecurity.httpBasic(Customizer.withDefaults());

        // This is to disable CSRF for CURL POST/PUT
        // curl -i -XPOST http://localhost:8080/api/students \
        // -H 'Content-Type: application/json' -d '{"firstName":"P1", "email":"e1"}' \
        // -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"
//        httpSecurity.csrf().disable();
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

    // JDBC-based users / roles
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    // Hardcoded users / roles
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        // curl -v -XPOST http://localhost:8080/api/employees \
//        // -H 'Content-Type: application/json' -d '{"firstName":"Joe", "email":"a@a.a"}' \
//        // -u "joe:test123"
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails joe = User.builder()
//                .username("joe")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails jack = User.builder()
//                .username("jack")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, jack, jack);
//    }
}
