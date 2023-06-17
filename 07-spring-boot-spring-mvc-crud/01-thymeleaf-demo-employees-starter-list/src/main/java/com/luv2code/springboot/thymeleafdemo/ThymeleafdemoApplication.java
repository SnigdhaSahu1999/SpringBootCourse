package com.luv2code.springboot.thymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}

/* Two controllers are present in this project:

1.  DemoController -	 http://localhost:8090/hello
2.  EmployeeController - http://localhost:8090/employees/list    */