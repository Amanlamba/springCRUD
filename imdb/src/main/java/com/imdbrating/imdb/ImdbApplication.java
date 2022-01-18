package com.imdbrating.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.imdbrating.imdb.*")
public class ImdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

}
