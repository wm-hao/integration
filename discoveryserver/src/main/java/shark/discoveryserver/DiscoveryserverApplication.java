package shark.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DiscoveryserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryserverApplication.class, args);
    }

}

