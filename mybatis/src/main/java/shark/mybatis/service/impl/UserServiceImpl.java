package shark.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shark.mybatis.mapper.UserMapper;
import shark.mybatis.pojo.User;
import shark.mybatis.service.interfaces.UserService;

import java.util.List;

/**
 * @author zhuhh 2019/1/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser() throws Exception {
        return userMapper.getUser();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    @Override
    public void updateT(User user) {
        userMapper.updateT(user);
    }
}
