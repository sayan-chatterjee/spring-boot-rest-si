package com.pwc.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config/integration.xml")
public class Application {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		props.setProperty("proxyHost", "10.31.8.34");
		props.setProperty("proxyPort", "8080");
		
		SpringApplication.run(Application.class, args);
	}
}