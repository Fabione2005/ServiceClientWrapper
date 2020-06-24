package com.index.client.clientIndex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.index.client.controller","com.index.client.service"})
@SpringBootApplication
public class ClientIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientIndexApplication.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
