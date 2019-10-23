package shark.consulproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ServiceController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String ip = request.getServerName();
        int port = request.getServerPort();
        return "hello 1 from " + ip + ":" + port;
    }
}
