package shark.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhh 2019/1/28
 */
@RestController
public class ResourceController {

    private static final Logger log = LoggerFactory.getLogger(RestController.class);

    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        log.info("resources: user {}", authentication);
        return authentication;
    }


}
