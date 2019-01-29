package shark.oauth2client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import shark.oauth2client.dao.Oauth2ClientDAO;
import shark.oauth2client.dao.Oauth2UserDAO;
import shark.oauth2client.pojo.Oauth2Client;
import shark.oauth2client.pojo.Oauth2User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Oauth2clientApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Oauth2clientApplicationTests.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Oauth2UserDAO oauth2UserDAO;
    @Autowired
    private Oauth2ClientDAO oauth2ClientDAO;

    @Test
    public void token_password() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", "admin");
        params.add("password", "admin");
        params.add("scope", "scope1 scope2");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_client() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }


    @Test
    public void encodePassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        List<Oauth2User> users = oauth2UserDAO.findAll();
        log.error("查询user:" + users.size());
        for (Oauth2User user : users) {
            System.out.println(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            oauth2UserDAO.save(user);
        }
    }


    @Test
    public void qryClient() {
        List<Oauth2Client> clients = oauth2ClientDAO.findAll();
        for(Oauth2Client client : clients) {
            log.error(client.toString());
        }
    }
}

