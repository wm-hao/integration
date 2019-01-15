package shark.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "shark")
public class RibbonclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonclientApplication.class, args);
    }

}

