package shark.zookeeperconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shark.zookeeperconsumer.service.SimpleService;

/**
 * @author zhuhh 2019/1/17
 */
@RestController
public class SimpleController {

    @Autowired
    SimpleService simpleService;

    @GetMapping("/getRandom")
    public String getRandom() {
        return simpleService.getRandom();
    }
}
