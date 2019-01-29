package shark.oauth2client.service.interfaces;

import shark.oauth2client.pojo.Oauth2Client;
import shark.oauth2client.pojo.Oauth2User;

import java.util.List;

/**
 * @author zhuhh 2019/1/29
 */
public interface Oauth2Service {

    List<Oauth2Client> getAllByClientId(String clientId);

    List<Oauth2User> getAllByUsername(String username);
}
