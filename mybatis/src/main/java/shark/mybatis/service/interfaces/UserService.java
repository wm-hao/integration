package shark.mybatis.service.interfaces;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import shark.mybatis.pojo.User;

import java.util.List;

/**
 * @author zhuhh 2019/1/22
 */
public interface UserService {

    List<User> getUser() throws Exception;

    void deleteUser(int id) throws Exception;

    void addUser(User user) throws Exception;

    void updateT(User user);
}
