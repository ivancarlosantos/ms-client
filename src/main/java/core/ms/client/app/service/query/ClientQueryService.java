package core.ms.client.app.service.query;

import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.cross.utils.ValidationParameter;
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
import java.util.Optional;

@Slf4j
@Service
public class ClientQueryService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ClientResponse> listAll() {
        log.info("[getAll] Fetch");
        List<Client> clientDomain = clientRepository
                .findAll()
                .stream()
                .filter(c -> c.getStatus().equals(ClientStatus.ATIVO.toString()))
                .toList();
        Type listType = new TypeToken<List<ClientResponse>>() {}.getType();
        return mapper.map(clientDomain, listType);
    }

    public ClientResponse findByID(String value) {
        Long id = ValidationParameter.validate(value);
        Optional<Client> find = Optional.of(clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client ID: " + id + " NOT FOUND")));
        return mapper.map(find.get(), ClientResponse.class);
    }
}
