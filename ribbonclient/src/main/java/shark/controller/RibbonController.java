package shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String getMessage() {
        return restTemplate.getForObject(serviceUrl + "service", String.class);
    }
}
