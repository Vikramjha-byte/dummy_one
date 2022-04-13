package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.beans.Student;

@Configuration
//@ComponentScan("com")
@Import(JavaConfig1.class)
@PropertySource("classpath:application.properties")
public class JavaConfiguration {
	
	@Bean
	public Student getStudent() {
		
		return new Student();
	}

}
