package shark.oauth2client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shark.oauth2client.dao.Oauth2ClientDAO;
import shark.oauth2client.dao.Oauth2UserDAO;
import shark.oauth2client.pojo.Oauth2Client;
import shark.oauth2client.pojo.Oauth2User;
import shark.oauth2client.service.interfaces.Oauth2Service;

import java.util.List;

/**
 * @author zhuhh 2019/1/29
 */

@Service
public class Oauth2ServiceImpl implements Oauth2Service {

    @Autowired
    Oauth2ClientDAO oauth2ClientDAO;

    @Autowired
    Oauth2UserDAO oauth2UserDAO;

    @Override
    public List<Oauth2Client> getAllByClientId(String clientId) {
        return oauth2ClientDAO.getAllByClientId(clientId);
    }

    @Override
    public List<Oauth2User> getAllByUsername(String username) {
        return oauth2UserDAO.getAllByUsername(username);
    }
}
