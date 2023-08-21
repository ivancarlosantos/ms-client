package core.ms.client.app.service.clientmaintence;

import core.ms.client.app.dto.request.ClientRequest;
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
public class ClientServiceMaintence {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TokenRequest tokenRequest;
    @Autowired
    private ModelMapper mapper;

    public ClientRequest insert(ClientRequest clientRequest) {
        Token nodeId = tokenRequest.generatedToken();
        Client client = Client.builder()
                .name(clientRequest.getName())
                .nodId(nodeId.getToken()).
                age(clientRequest.getAge())
                .status(ClientStatus.ATIVO.toString())
                .document(clientRequest.getDocument()).build();


        clientRepository.save(client);
        return mapper.map(client, ClientRequest.class);
    }

    public ClientRequest delete(Long id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client não encotrado"));
        client.setStatus(ClientStatus.INATIVO.toString());
        return mapper.map(client, ClientRequest.class);
    }

    public ClientRequest update(Long id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Id not Found"));


        return mapper.map(client, ClientRequest.class);
    }

}
