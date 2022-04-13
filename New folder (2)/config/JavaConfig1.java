package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.College;
@Configuration
public class JavaConfig1 {
	@Bean
	public College getCollege()
	{
		return new College();
		
	}

}
