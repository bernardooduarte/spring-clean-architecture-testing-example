package com.exemplo.condominio.infrastructure.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    public static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("condominio_db")
            .withUsername("test")
            .withPassword("test");

    static {
        postgres.start();
    }
}