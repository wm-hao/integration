package shark.service;

import org.springframework.stereotype.Component;

/**
 * @author zhuhh 2019/1/17
 */
@Component
public class UserClientFallbackImpl implements UserClient {
    @Override
    public String getMessage() {
        return "Sorry ribbon service is not available now";
    }
}
