package shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shark.service.UserClient;

/**
 * @author zhuhh 2019/1/16
 */

@RestController
public class UserController {

    @Autowired
    UserClient userClient;

    @GetMapping("/feign")
    public String getMessage() {
        return userClient.getMessage();
    }
}
