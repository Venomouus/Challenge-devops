package br.com.fiap.tein8.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    
        http
            .httpBasic()
            .and()
            .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/empresa/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/empresa").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/empresa/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/empresa/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/aplicacao/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/aplicacao").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/aplicacao/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/aplicacao/**").permitAll()
                .anyRequest().denyAll()
            .and()
                .csrf().disable()
        ;

       return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
