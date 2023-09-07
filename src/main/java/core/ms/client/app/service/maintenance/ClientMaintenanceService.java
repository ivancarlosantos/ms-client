package core.ms.client.app.service.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.cross.utils.TokenRequest;
import core.ms.client.cross.utils.ValidationParameter;
import core.ms.client.exceptions.BusinessException;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.domain.Token;
import core.ms.client.infra.repository.ClientRepository;
import core.ms.client.status.ClientStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientMaintenanceService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TokenRequest tokenRequest;

    @Autowired
    private ModelMapper mapper;

    public ClientResponse save(ClientRequest request) {
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

    public ClientResponse clientStatus(String value, String status) {
        Long id = ValidationParameter.validate(value);
        Optional<Client> findClient = Optional
                .ofNullable(clientRepository
                        .findById(id)
                        .orElseThrow(() -> new BusinessException("Client ID: " + id + " NOT FOUND")));

        if (findClient.get().getStatus().equals(ClientStatus.ATIVO.toString())) {
            findClient.get().setStatus(status);
            clientRepository.save(findClient.get());
        }

        if (findClient.get().getStatus().equals(ClientStatus.INATIVO.toString())) {
            findClient.get().setStatus(status);
            clientRepository.save(findClient.get());
        }

        return mapper.map(findClient.get(), ClientResponse.class);
    }

    public ClientResponse update(String value, ClientRequest clientRequest) {
        Long id = ValidationParameter.validate(value);
        Client client = clientRepository.findById(id).
                orElseThrow(() -> new BusinessException("ID NOT FOUND"));

        client.setName(clientRequest.getName());
        client.setAge(clientRequest.getAge());
        client.setDocument(clientRequest.getDocument());
        client.setStatus(clientRequest.getStatus());

        clientRepository.save(client);

        return mapper.map(client, ClientResponse.class);
    }
}
