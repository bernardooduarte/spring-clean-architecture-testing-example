package com.exemplo.condominio;

import com.exemplo.condominio.infrastructure.BaseIntegrationTest;
import com.exemplo.condominio.infrastructure.config.TestContainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestContainersConfiguration.class)
@SpringBootTest
class CondominioApplicationTests extends BaseIntegrationTest {

	@Test
	void contextLoads() {
	}

}
