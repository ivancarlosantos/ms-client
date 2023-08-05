package core.ms.client.app.controller.maintenance;

import core.ms.client.app.service.ClientService;
import core.ms.client.infra.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientMaintenanceController {
    @Autowired
private ClientService clientService;

@GetMapping
public ResponseEntity<List<Client>>findAll(){
    List<Client>listClient=clientService.findAll();
    return ResponseEntity.ok().body(listClient);
}
@GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
    Client clienId= clientService.findById(id);
    return ResponseEntity.ok(clienId);
}
}
