package com.exemplo.condominio.infrastructure;

import com.exemplo.condominio.infrastructure.config.TestContainersConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainersConfiguration.class)
public abstract class BaseIntegrationTest {

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", TestContainersConfiguration.postgres::getJdbcUrl);
        registry.add("spring.datasource.username", TestContainersConfiguration.postgres::getUsername);
        registry.add("spring.datasource.password", TestContainersConfiguration.postgres::getPassword);
    }
}