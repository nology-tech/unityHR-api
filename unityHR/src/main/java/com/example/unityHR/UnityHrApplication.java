package com.example.unityHR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class UnityHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnityHrApplication.class, args);
	}

}
