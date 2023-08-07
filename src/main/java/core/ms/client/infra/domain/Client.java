package core.ms.client.infra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Client implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nodId;
    private Integer age;
    private String document;
}
