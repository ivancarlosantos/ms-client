package core.ms.client.infra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@SuperBuilder

public class Token implements Serializable {
    private UUID id;
    private String token;
    private LocalDateTime timeStamp;

}
