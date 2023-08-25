package core.ms.client.app.service.query;

import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.exceptions.BusinessException;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.repository.ClientRepository;
import core.ms.client.status.ClientStatus;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class ClientServiceQuery {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ClientResponse> convertEntityToDTOList() {
        log.info("[getAll] Fetch");
        List<Client> clientDomain = clientRepository
                .findAll()
                .stream()
                .filter(c->c.getStatus().equals(ClientStatus.ATIVO.toString()))
                .toList();

        Type listType = new TypeToken<List<ClientResponse>>(){}.getType();
        return mapper.map(clientDomain, listType);
    }

    public ClientResponse getById(Long id){
        log.info("[getById] - Fetch id {}", id);
        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException(""));
        return mapper.map(client, ClientResponse.class);
    }
}
