package com.pamit.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.pamit.springbootmvc", "com.pamit.springbootdemo" })
public class SpringbootMvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMvcApplication.class, args);
	}
}
