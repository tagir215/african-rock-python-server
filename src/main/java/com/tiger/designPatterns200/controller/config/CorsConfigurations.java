package com.tiger.designPatterns200.controller.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class CorsConfigurations implements WebMvcConfigurer {

	@Value("${url.local.frontend}")
	private String frontendUrlLocal;
	@Value("${url.deployed.frontend")
	private String frontendUrlDeployed;

	

   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
           .allowedOrigins(frontendUrlLocal,frontendUrlDeployed) 
           .allowCredentials(true)
           .exposedHeaders("*")
           .maxAge(3600L)
           .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
       	   .allowedHeaders("*");
   }
   

}