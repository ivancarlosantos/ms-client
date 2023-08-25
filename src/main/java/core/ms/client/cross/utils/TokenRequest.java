package core.ms.client.cross.utils;

import core.ms.client.infra.domain.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nodeId", url = "http://localhost:8086")
public interface TokenRequest {
    @GetMapping("/api/token")
    Token generatedToken();


}
