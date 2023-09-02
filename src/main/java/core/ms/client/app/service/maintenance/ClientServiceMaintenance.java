package core.ms.client.app.service.maintenance;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.cross.utils.TokenRequest;
import core.ms.client.exceptions.BusinessException;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.domain.Token;
import core.ms.client.infra.repository.ClientRepository;
import core.ms.client.status.ClientStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceMaintenance {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TokenRequest tokenRequest;
    @Autowired
    private ModelMapper mapper;

    public ClientResponse insert(ClientRequest clientRequest) {
        Token nodeId = tokenRequest.generatedToken();
        Client client = Client.builder()
                .name(clientRequest.getName())
                .nodeId(nodeId.getToken()).
                age(clientRequest.getAge())
                .status(ClientStatus.ATIVO.toString())
                .document(clientRequest.getDocument()).build();
        clientRepository.save(client);
        return mapper.map(client, ClientResponse.class);
    }

    public ClientResponse delete(Long id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).
                orElseThrow(() -> new BusinessException("Client não encotrado"));
        client.setStatus(ClientStatus.INATIVO.toString());
        return mapper.map(client, ClientResponse.class);
    }

    public ClientResponse update(Long id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).
                orElseThrow(() -> new BusinessException("Id not Found"));
        client.setName(clientRequest.getName());
        client.setAge(clientRequest.getAge());
        client.setDocument(clientRequest.getDocument());
        client.setStatus(clientRequest.getStatus());

        return mapper.map(client, ClientResponse.class);
    }

}
