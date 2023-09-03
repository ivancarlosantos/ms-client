package core.ms.client;

import core.ms.client.infra.domain.Client;
import core.ms.client.status.ClientStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ClientModelApplicationTests {

	@Test
	void test() {
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

}
