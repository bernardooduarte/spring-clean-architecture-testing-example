package com.exemplo.condominio;

import com.exemplo.condominio.infrastructure.config.TestContainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestCondominioApplication {

	public static void main(String[] args) {
		SpringApplication.from(CondominioApplication::main).with(TestContainersConfiguration.class).run(args);
	}

}
