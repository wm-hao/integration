package shark.oauth2client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import shark.oauth2client.pojo.Oauth2Client;
import shark.oauth2client.pojo.Oauth2User;
import shark.oauth2client.service.interfaces.Oauth2Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuhh 2019/1/29
 */
@Configuration
public class Oauth2Config {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(Oauth2Service oauth2Servic) {
        return username -> {
            List<Oauth2User> users = oauth2Servic.getAllByUsername(username);
            if (users == null || users.size() == 0) {
                throw new UsernameNotFoundException("username无效");
            }
            Oauth2User user = users.get(0);
            return User.withUsername(username).password(user.getPassword()).roles("").build();
        };
    }


    @Bean
    public ClientDetailsService clientDetailsService(Oauth2Service oauth2Service, PasswordEncoder passwordEncoder) {
        return clientId -> {
            List<Oauth2Client> clients = oauth2Service.getAllByClientId(clientId);
            if (clients == null || clients.size() == 0) {
                throw new ClientRegistrationException("clientId无效");
            }
            Oauth2Client client = clients.get(0);
            String clientSecretAfterEncoder = passwordEncoder.encode(client.getClientSecret());
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId(client.getClientId());
            clientDetails.setClientSecret(clientSecretAfterEncoder);
            clientDetails.setRegisteredRedirectUri(new HashSet<>(Arrays.asList(client.getRedirectUrl().split(","))));
            clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getGrantType().split(",")));
            clientDetails.setScope(Arrays.asList(client.getScope().split(",")));
            return clientDetails;
        };
    }

    @Bean
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, OAuth2Authentication> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();

        return new RandomValueAuthorizationCodeServices() {
            @Override
            protected void store(String code, OAuth2Authentication oAuth2Authentication) {
                redisTemplate.boundValueOps(code).set(oAuth2Authentication, 10, TimeUnit.MINUTES);
            }

            @Override
            protected OAuth2Authentication remove(String code) {
                OAuth2Authentication oAuth2Authentication = redisTemplate.boundValueOps(code).get();
                redisTemplate.delete(code);
                return oAuth2Authentication;
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(Collections.singletonList(provider));
    }

    @Bean
    public AuthorizationServerConfigurer authorizationServerConfigurer(UserDetailsService userDetailsService, ClientDetailsService clientDetailsService,
                                                                       TokenStore tokenStore, AuthorizationCodeServices authorizationCodeServices, AuthenticationManager authenticationManager) {
        return new AuthorizationServerConfigurer() {
            @Override
            public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {

            }

            @Override
            public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
                clientDetailsServiceConfigurer.withClientDetails(clientDetailsService);
            }

            @Override
            public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {
                authorizationServerEndpointsConfigurer.userDetailsService(userDetailsService);
                authorizationServerEndpointsConfigurer.tokenStore(tokenStore);
                authorizationServerEndpointsConfigurer.authorizationCodeServices(authorizationCodeServices);
                authorizationServerEndpointsConfigurer.authenticationManager(authenticationManager);
            }
        };
    }

}
