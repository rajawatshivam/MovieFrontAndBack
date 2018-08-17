package com.stackroute.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MovieServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(MovieServiceApplication.class, args);
		
		
	}
}


//Design patterns(gang of 4)
//singleton
//factory
//builder
//decompile