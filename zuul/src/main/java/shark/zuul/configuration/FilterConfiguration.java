package shark.zuul.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shark.zuul.filter.AccessFilter;

/**
 * @author zhuhh 2019/1/16
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
