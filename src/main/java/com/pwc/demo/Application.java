package com.pwc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"com.pwc"})
@ImportResource("classpath:config/integration.xml") 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}