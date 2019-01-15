package shark.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhh 2019/1/15
 */

@RestController
public class ServiceController {

    @Value("${server.port}")
    int port;

    @GetMapping("/service")
    public String getMessage() {
        return "Hello you're so smart! receive from port : " + port;
    }
}
