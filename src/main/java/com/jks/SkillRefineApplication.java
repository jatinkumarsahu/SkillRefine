package com.jks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller","com.model.dto"})
public class SkillRefineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillRefineApplication.class, args); 
	}
 
}
