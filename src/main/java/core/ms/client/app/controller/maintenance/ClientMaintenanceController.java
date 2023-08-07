package core.ms.client.app.controller.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.ClientService;
import core.ms.client.infra.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientMaintenanceController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientRequest>> findAll() {
        List<ClientRequest> listClient = clientService.findAll();
        return ResponseEntity.ok().body(listClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientRequest> findById(@PathVariable Long id) {
        ClientRequest clientRequestId = clientService.findById(id);
        return ResponseEntity.ok(clientRequestId);
    }

    @PostMapping
    public ResponseEntity<ClientRequest> insert(@RequestBody ClientRequest clientRequest) {
        clientRequest = clientService.insert(clientRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(clientRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientRequest> update(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        clientRequest = clientService.update(id, clientRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(clientRequest);
    }
}
