package shark.zookeeperconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuhh 2019/1/17
 */
@FeignClient("zookeeper-discovery-server")
public interface SimpleService {

    @GetMapping("/getRandom")
    String getRandom();
}
