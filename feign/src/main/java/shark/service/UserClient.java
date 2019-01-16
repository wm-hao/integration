package shark.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuhh 2019/1/16
 */
@FeignClient("service")
public interface UserClient {

    @GetMapping("/service")
    String getMessage();
}
