package com.cursos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.cursos.controller","com.cursos.service"})
public class ProyectocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectocursosApplication.class, args);
	}

}
