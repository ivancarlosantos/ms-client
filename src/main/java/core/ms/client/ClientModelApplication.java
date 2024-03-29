package core.ms.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class ClientModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientModelApplication.class, args);
        log.info("Client UP [" + HttpStatus.OK + "]");
    }
}
