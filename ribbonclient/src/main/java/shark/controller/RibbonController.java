package shark.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author zhuhh 2019/1/15
 */

@RestController
public class RibbonController {

    @Value("${serviceInfo.serviceUrl}")
    String serviceUrl;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    @HystrixCommand(fallbackMethod = "getMessageWhileErr")
    public String getMessage() {
        return restTemplate.getForObject(serviceUrl + "service", String.class);
    }

    public String getMessageWhileErr() {
        return "Sorry ribbon service is not available now " + new Date();
    }
}
