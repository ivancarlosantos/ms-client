package core.ms.client.app.controller.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.maintenance.ClientServiceMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientControllerMaintenance {
    @Autowired
    private ClientServiceMaintenance clientService;


    @PostMapping
    public ResponseEntity<ClientResponse> insert(@RequestBody ClientRequest clientRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.insert(clientRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {


        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.update(id, clientRequest));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<ClientResponse> delete(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.delete(id, clientRequest));
    }


}
