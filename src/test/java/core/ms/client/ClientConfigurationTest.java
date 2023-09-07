package core.ms.client;

import core.ms.client.infra.domain.Client;
import core.ms.client.infra.repository.ClientRepository;
import core.ms.client.status.ClientStatus;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientConfigurationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private ClientRepository clientRepository;

    @Container
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:11"));

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);

        log.info("url {}", container.getJdbcUrl());
        log.info("username {}", container.getUsername());
        log.info("password {}", container.getPassword());
        log.info("spring.datasource.driver-class-name {}", container.getJdbcDriverInstance());
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        clientRepository.deleteAll();
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
    void testDomain() {
        Long id = 1L;
        String name = "name";
        Integer age = 99;
        String document = "12.345.678-00";
        String nodeID = UUID.randomUUID().toString();
        String status = ClientStatus.ATIVO.toString();

        Client client = new Client(id, name, age, document, nodeID, status);

        assertNotNull(client);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(age, client.getAge());
        assertEquals(document, client.getDocument());
        assertEquals(nodeID, client.getNodeID());
        assertEquals(status, client.getStatus());
    }

    @Test
    void testNameClient() {
        Client p = new Client();
        p.setName("Fulano");
        Assertions.assertEquals("Fulano", p.getName());
    }

    @Test
    void testNameClientNull() {
        Client p = new Client();
        p.setName(null);
        Assertions.assertNull(p.getName());
    }

}
