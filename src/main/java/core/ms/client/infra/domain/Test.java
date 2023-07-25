package core.ms.client.infra.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.net.InetAddress;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Test implements Serializable {

    private String uuid;
    private String timestamp;
    private InetAddress address;
}
