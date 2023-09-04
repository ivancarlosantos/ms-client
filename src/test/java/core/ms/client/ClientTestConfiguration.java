package core.ms.client;

import core.ms.client.infra.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Slf4j
@Testcontainers
@SpringBootTest
public class ClientTestConfiguration {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer(
            DockerImageName.parse("postgres:11"));

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);

        log.info("url {}", container.getJdbcUrl());
        log.info("username {}", container.getUsername());
        log.info("password {}", container.getPassword());
        log.info("spring.datasource.driver-class-name {}", container.getJdbcDriverInstance());
    }

    @BeforeAll
    static void beforeAll() {
        container.start();
    }

    @AfterAll
    static void afterAll() {
        container.stop();
    }

    @Test
    void testNomeCliente() {
        Client p = new Client();
        p.setName("Fulano");
        Assertions.assertEquals("Fulano", p.getName());
    }

    @Test
    void testNomeClienteNull() {
        Client p = new Client();
        p.setName(null);
        Assertions.assertNull(p.getName());
    }
}
