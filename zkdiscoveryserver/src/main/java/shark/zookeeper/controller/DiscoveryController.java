package shark.zookeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhuhh 2019/1/17
 */
@RestController
public class DiscoveryController {

    private static final UUID INSTANCE_ID = UUID.randomUUID();

    @GetMapping("/getRandom")
    public String getRandom() {
        return INSTANCE_ID.toString();
    }
}
