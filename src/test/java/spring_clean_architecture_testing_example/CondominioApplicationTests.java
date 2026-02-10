package spring_clean_architecture_testing_example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class CondominioApplicationTests {

	@Test
	void contextLoads() {
	}

}
