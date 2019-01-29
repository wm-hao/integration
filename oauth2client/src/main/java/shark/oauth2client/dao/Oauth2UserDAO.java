package shark.oauth2client.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shark.oauth2client.pojo.Oauth2User;

import java.util.List;

/**
 * @author zhuhh 2019/1/29
 */
public interface Oauth2UserDAO extends JpaRepository<Oauth2User, Integer> {

    List<Oauth2User> getAllByUsername(String username);
}
