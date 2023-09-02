package core.ms.client.app.dto.response;

import core.ms.client.infra.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ClientResponse implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String document;
    private String status;
    private String nodeId;


}
