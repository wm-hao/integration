package shark.zookeeperconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "shark")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "shark")
public class ZookeeperconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperconsumerApplication.class, args);
    }

}

