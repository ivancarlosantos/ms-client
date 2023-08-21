package core.ms.client.app.controller.maintenance;

import com.fasterxml.jackson.databind.util.TokenBufferReadContext;
import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.service.clientmaintence.ClientServiceMaintence;
import core.ms.client.cross.utils.TokenRequest;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientMaintenanceController {
    @Autowired
    private ClientServiceMaintence clientService;


    @PostMapping
    public ResponseEntity<ClientRequest> insert(@RequestBody ClientRequest clientRequest) {

        clientRequest = clientService.insert(clientRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientRequest> update(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        clientRequest = clientService.update(id, clientRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(clientRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientRequest> delete(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        clientRequest = clientService.delete(id, clientRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(clientRequest);
    }


}
