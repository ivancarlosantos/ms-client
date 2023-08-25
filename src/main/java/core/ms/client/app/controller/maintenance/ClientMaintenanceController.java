package core.ms.client.app.controller.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.app.service.maintenance.ClientMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/domain/client")
public class ClientMaintenanceController {

    @Autowired
    private ClientMaintenanceService clientMaintenanceService;


    @PostMapping(path = "/save")
    public ResponseEntity<ClientResponse> persist(@RequestBody ClientRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientMaintenanceService.save(request));
    }
}
