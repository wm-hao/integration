package shark.zookeepker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "shark")
@EnableDiscoveryClient
public class ZookeepkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeepkerApplication.class, args);
    }

}

