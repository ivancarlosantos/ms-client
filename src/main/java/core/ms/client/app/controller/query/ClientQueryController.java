package core.ms.client.app.controller.query;

import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.query.ClientQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private ClientQueryService clientQueryService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        List<ClientResponse> listClient = clientQueryService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(listClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable(name = "id") String value) {
        ClientResponse response = clientQueryService.findByID(value);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
