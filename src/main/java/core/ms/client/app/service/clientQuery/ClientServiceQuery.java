package core.ms.client.app.service.clientQuery;

import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.exceptions.BusinessException;
import core.ms.client.infra.domain.Client;
import core.ms.client.infra.repository.ClientRepository;
import core.ms.client.status.ClientStatus;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceQuery {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper mapper;

    public List<ClientResponse> findAll() {
        List<Client> clientList = clientRepository.findAll()
                .stream()
                .filter(client -> client.getStatus().equals(ClientStatus.ATIVO
                        .toString()))
                .toList();
        Type tipo = new TypeToken<List<ClientResponse>>() {
        }.getType();

        return mapper.map(clientList, tipo);

    }

    public ClientResponse findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Id not Found"));
        return mapper.map(client, ClientResponse.class);
    }
}
