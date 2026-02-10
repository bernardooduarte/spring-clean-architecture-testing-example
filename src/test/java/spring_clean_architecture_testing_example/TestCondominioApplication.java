package spring_clean_architecture_testing_example;

import com.exemplo.condominio.CondominioApplication;
import org.springframework.boot.SpringApplication;

public class TestCondominioApplication {

	public static void main(String[] args) {
		SpringApplication.from(CondominioApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
