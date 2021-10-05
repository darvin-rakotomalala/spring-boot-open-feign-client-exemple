package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Spring Boot Feign Client API REST", version = "2.0", description = "Exemple Feign Client dabs Spring Boot"))
public class SpringBootOpenFeignClientExempleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOpenFeignClientExempleApplication.class, args);
	}

}
