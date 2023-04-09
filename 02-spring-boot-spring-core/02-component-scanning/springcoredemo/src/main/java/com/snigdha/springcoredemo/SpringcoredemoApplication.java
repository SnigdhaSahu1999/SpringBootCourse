package com.snigdha.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication(

		scanBasePackages = {"com.snigdha.springcoredemo",
								  "com.snigdha.util"})
//scanBasePackages is used for component scanning outside the package of main SpringcoredemoApplication class
*/

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
