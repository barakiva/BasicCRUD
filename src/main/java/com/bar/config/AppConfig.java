package com.bar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String pass;
	
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName(driverClass)
          .url(url)
          .username(username)
          .password(pass)
          .build(); 
    }
   
}
