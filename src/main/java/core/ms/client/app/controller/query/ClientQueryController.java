package core.ms.client.app.controller.query;

import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.clientQuery.ClientServiceQuery;
import core.ms.client.cross.utils.ValidationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientQueryController {
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


}
