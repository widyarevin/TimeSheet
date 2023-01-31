package com.example.Timsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TimsheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimsheetApplication.class, args);
		System.out.println("Hello");
	}


}
