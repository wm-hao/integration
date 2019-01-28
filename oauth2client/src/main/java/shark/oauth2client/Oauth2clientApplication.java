package shark.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication(scanBasePackages = "shark")
@EnableAuthorizationServer
public class Oauth2clientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2clientApplication.class, args);
    }

}

