package core.ms.client.cross.assembler;
import core.ms.client.app.dto.request.ClientRequest;
import core.ms.client.app.dto.response.ClientResponse;
import core.ms.client.infra.domain.Client;

public interface ClientMapper {
    Client toEntity(ClientRequest request);

    ClientResponse toResponse(Client client);
}
