package shark.zipkinmine;

import brave.sampler.Sampler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinmineApplication {
    private static Log log = LogFactory.getLog(ZipkinmineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZipkinmineApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/mine")
    public String hi() {
        log.error("service mine is called : mine");
        return restTemplate.getForObject("http://localhost:12002/info", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        log.error("service mine show info");
        return "i'm service mine";
    }

    @Bean
    public Sampler sampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}

