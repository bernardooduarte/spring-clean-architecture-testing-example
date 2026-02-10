package com.exemplo.condominio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import spring_clean_architecture_testing_example.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class CondominioApplicationTests {

	@Test
	void contextLoads() {
	}

}
