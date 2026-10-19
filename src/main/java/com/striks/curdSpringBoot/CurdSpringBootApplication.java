package com.striks.curdSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CurdSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdSpringBootApplication.class, args);
		System.out.print("Spring Boot Application is running on port 8080");
	}

}
