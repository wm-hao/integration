package shark.oauth2client.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shark.oauth2client.pojo.Oauth2Client;

import java.util.List;

/**
 * @author zhuhh 2019/1/29
 */
public interface Oauth2ClientDAO extends JpaRepository<Oauth2Client, Integer> {

    List<Oauth2Client> getAllByClientId(String clientId);

    Oauth2Client getByClientSecret(String clientSecret);

}
