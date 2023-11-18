package com.tiger.designPatterns200.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
           .csrf(csrf -> csrf.disable())
           .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/api/v*/user/**","/api/v*/getComputers/**","/api/v*/cart/**").permitAll()
                   .anyRequest().authenticated()
        		   )
           .httpBasic(Customizer.withDefaults());
        return http.build();
         
    }
	
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	}
	

	
	
}
