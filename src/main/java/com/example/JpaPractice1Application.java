package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@ComponentScan(basePackages={"com.example.controller"})

@SpringBootApplication
public class JpaPractice1Application extends SpringBootServletInitializer{

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaPractice1Application.class, args);
	}
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JpaPractice1Application.class);
		
	}

}
