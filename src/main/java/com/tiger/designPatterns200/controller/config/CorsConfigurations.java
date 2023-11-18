package com.tiger.designPatterns200.controller.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfigurations implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
           .allowedOrigins("http://localhost:3000","https://arp-client-c1df0d4c8a26.herokuapp.com") 
           .allowCredentials(true)
           .allowedMethods("GET", "POST", "PUT", "DELETE")
       	   .allowedHeaders("*");
   }
   
}