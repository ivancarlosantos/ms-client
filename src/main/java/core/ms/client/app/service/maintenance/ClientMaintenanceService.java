package core.ms.client.app.service.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.cross.utils.TokenRequest;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.domain.ClientStatus;
import core.ms.client.infra.domain.Token;
import core.ms.client.infra.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientMaintenanceService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TokenRequest tokenRequest;

    @Autowired
    private ModelMapper mapper;

    public ClientResponse save(ClientRequest request){
        Token token = tokenRequest.generateToken();
        Client client = Client.builder()
                .name(request.getName())
                .age(request.getAge())
                .document(request.getDocument())
                .nodeID(token.getToken())
                .status(ClientStatus.ATIVO.toString())
                .build();
        clientRepository.save(client);
        return mapper.map(client, ClientResponse.class);
    }
}
