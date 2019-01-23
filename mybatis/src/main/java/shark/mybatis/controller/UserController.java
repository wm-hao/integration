package shark.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shark.mybatis.mapper.DepartmentMapper;
import shark.mybatis.pojo.Department;
import shark.mybatis.pojo.User;
import shark.mybatis.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhh 2019/1/22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping(value = "/get")
    public List<User> show() {
        try {
            List<User> users = userService.getUser();
            for (User user : users
            ) {
                System.out.println(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GetMapping("/create")
    public User createUser() {
        User user = new User();
        user.setAge(22);
        user.setUsername("xxx" + System.currentTimeMillis());
        Department department = departmentMapper.getDeptById(1);
        user.setDepartment(department);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(String id) {
        try {
            userService.deleteUser(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

}
