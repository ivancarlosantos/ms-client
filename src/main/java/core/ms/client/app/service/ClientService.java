package core.ms.client.app.service;

import core.ms.client.infra.domain.Client;
import core.ms.client.infra.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client>clientId= clientRepository.findById(id);
        Client client=clientId.get();
        return client;
    }
}
