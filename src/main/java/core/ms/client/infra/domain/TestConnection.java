package core.ms.client.infra.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.net.InetAddress;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class TestConnection implements Serializable {

    private String uuid;
    private String timestamp;
    private InetAddress address;
}
