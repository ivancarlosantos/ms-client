package core.ms.client.app.controller.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.maintenance.ClientMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientMaintenanceController {

    @Autowired
    private ClientMaintenanceService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> insert(@RequestBody ClientRequest clientRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable String id, @RequestBody ClientRequest clientRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.update(id, clientRequest));
    }

    @PutMapping("/delete/{id}/{status}")
    public ResponseEntity<ClientResponse> delete(@PathVariable String id, @PathVariable String status) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.clientStatus(id, status));
    }
}
