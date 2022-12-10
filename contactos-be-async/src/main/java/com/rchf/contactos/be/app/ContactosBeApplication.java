package com.rchf.contactos.be.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class ContactosBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactosBeApplication.class, args);
	}

	// Es necesario para conectar un servicio
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

	// Se encarga de lanzar la llamada en modo Async
	// Se debe agregar @EnableAsync
	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
	}

}
