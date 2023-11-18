package com.tiger.designPatterns200.repository.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.tiger.designPatterns200.repository.annotation.MyTestProxyableAnnotation;
import com.tiger.designPatterns200.repository.computer.ComputerRepository;
import com.tiger.designPatterns200.repository.computer.ComputerRepositoryImpl;
import com.tiger.designPatterns200.repository.computer.ComputerRepositoryProxy;

@Configuration
public class RepositoryConfigurations {

   
   @Value("${spring.datasource.url}")
   private String url;

   @Value("${spring.datasource.username}")
   private String username;

   @Value("${spring.datasource.password}")
   private String password;

   @Value("${spring.datasource.driver-class-name}")
   private String driverClassName;

   @Bean
   public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName(driverClassName);
       dataSource.setUrl(url);
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       return dataSource;
   }
   
   
   @Bean ComputerRepository myCustomRepository() {
	   ComputerRepositoryImpl repo = new ComputerRepositoryImpl();
	   if(ComputerRepositoryImpl.class.isAnnotationPresent(MyTestProxyableAnnotation.class)) {
		   return new ComputerRepositoryProxy(repo);
	   }
	   return repo;
   }
   
}
