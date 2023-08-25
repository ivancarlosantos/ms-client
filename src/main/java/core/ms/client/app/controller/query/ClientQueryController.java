package core.ms.client.app.controller.query;

import core.ms.client.app.dto.response.ClientResponse;
<<<<<<< HEAD
import core.ms.client.app.service.query.ClientQueryService;
import core.ms.client.cross.utils.ValidationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
=======
import core.ms.client.app.service.clientQuery.ClientServiceQuery;
import core.ms.client.cross.utils.ValidationParameter;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 640a797af448d4bd5deef2a976d61b77094769a2
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientQueryController {
<<<<<<< HEAD

    @Autowired
    private ClientQueryService clientQueryService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        List<ClientResponse> listClient = clientQueryService.convertEntityToDTOList();
        return ResponseEntity.status(HttpStatus.OK).body(listClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable(name = "id") String id) {
        Long value = ValidationParameter.validateParamLong(id);
        ClientResponse response = clientQueryService.getById(value);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
=======
    @Autowired
    private ClientServiceQuery clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        List<ClientResponse> listClient = clientService.findAll();
        return ResponseEntity.ok().body(listClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable String id) {
        Long value = ValidationParameter.validation(id);
        ClientResponse clientRequestId = clientService.findById(value);
        return ResponseEntity.ok(clientRequestId);
    }


>>>>>>> 640a797af448d4bd5deef2a976d61b77094769a2
}
