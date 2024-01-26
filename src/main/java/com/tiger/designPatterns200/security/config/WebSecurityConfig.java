package com.tiger.designPatterns200.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tiger.designPatterns200.security.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Value("${url.local.frontend}")
	private String frontendUrlLocal;
	@Value("${url.deployed.frontend")
	private String frontendUrlDeployed;

	private final JwtAuthFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;

	public WebSecurityConfig(JwtAuthFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
		this.jwtAuthFilter = jwtAuthFilter;
		this.authenticationProvider = authenticationProvider;
	}


	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
		   .cors(Customizer.withDefaults())
           .csrf(csrf -> csrf
        		   .disable())
           .authorizeHttpRequests(auth -> auth
                   .requestMatchers(
                		   "/api/v*/getComputers/**",
                		   "/api/v*/cart/**",
                		   "/login",
                		   "/registration")
                   .permitAll()
                   .anyRequest()
                   .authenticated())
		   .sessionManagement(session -> session
				   .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		   .authenticationProvider(authenticationProvider)
		   .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		   

        return http.build();
         
    }
	

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		//config.setAllowedOrigins(Arrays.asList(frontendUrlLocal,frontendUrlDeployed));
		config.addAllowedOrigin("*");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
		config.setAllowCredentials(true);
		var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
