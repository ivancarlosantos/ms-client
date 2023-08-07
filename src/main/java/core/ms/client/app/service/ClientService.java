package core.ms.client.app.service;

import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.exceptions.BusinessException;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientRequest> findAll() {
        List<Client> clientList = clientRepository.findAll();

        List<ClientRequest> clientRequests = clientList.stream().map(x -> new ClientRequest(x)).collect(Collectors.toList());
        List<ClientRequest> clientRequests1 = clientRequests;
        return clientRequests1;
    }

    public ClientRequest findById(Long id) {
        Optional<Client> clientId = clientRepository.findById(id);
        Client client = clientId.orElseThrow(() -> new BusinessException("Id not Found"));
        return new ClientRequest(client);
    }

    public ClientRequest insert(ClientRequest clientRequest) {
        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setAge(clientRequest.getAge());
        client.setDocument(clientRequest.getDocument());
        client.setNodId(clientRequest.getNodId());
        client = clientRepository.save(client);
        return new ClientRequest(client);
    }

    public ClientRequest update(Long id, ClientRequest clientRequest) {
        Client client = clientRepository.getOne(id);
        client.setName(clientRequest.getName());
        client.setAge(clientRequest.getAge());
        client.setDocument(clientRequest.getDocument());
        client.setNodId(clientRequest.getNodId());
        return new ClientRequest(client);
    }
}
