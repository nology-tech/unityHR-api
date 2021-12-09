package com.example.unityHR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
public class UnityHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnityHrApplication.class, args);
	}

}
