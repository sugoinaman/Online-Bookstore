package org.example.onlinebookstore;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityAdapter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http )throws Exception{

        http.authorizeHttpRequests(a->a
                .requestMatchers(",","/error").permitAll()
                .

    }

}
