package shark.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhh 2019/1/16
 */

@RestController
@RefreshScope
public class ConfigQueryController {

    @Value("${name}")
    String name;

    @Value("${cversion}")
    String currentVersion;

    @Value("${age}")
    int age;

    @Value("${address}")
    String address;

    @GetMapping("/getClientConfig")
    public String getClientConfig() {
        StringBuilder result = new StringBuilder();
        result.append("name=" + name + "\n");
        result.append("version=" + currentVersion + "\n");
        result.append("age=" + age + "\n");
        result.append("address=" + address + "\n");
        return result.toString();
    }
}
