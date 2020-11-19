package com.vic.sb16;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Sb16Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb16Application.class, args);
	}

}
