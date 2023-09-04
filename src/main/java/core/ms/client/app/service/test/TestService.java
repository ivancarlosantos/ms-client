package core.ms.client.app.service.test;

import core.ms.client.infra.domain.TestConnection;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Service
public class TestService {

    public List<TestConnection> test() throws UnknownHostException {

       TestConnection test =  TestConnection
                .builder()
                .uuid(UUID.randomUUID().toString())
                .address(InetAddress.getLocalHost())
                .timestamp(new Date().toString())
                .build();

       return Collections.singletonList(test);
    }
}
