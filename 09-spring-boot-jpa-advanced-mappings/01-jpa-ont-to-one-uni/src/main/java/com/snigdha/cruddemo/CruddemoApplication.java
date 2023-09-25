package com.snigdha.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//CommandLineRunner is from SB Framework, will be executed after the spring beans have been loaded and we can use
	// this with given method
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){

		// lambda expression
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
