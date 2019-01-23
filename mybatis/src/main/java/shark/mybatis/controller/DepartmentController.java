package shark.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shark.mybatis.mapper.DepartmentMapper;
import shark.mybatis.pojo.Department;

/**
 * @author zhuhh 2019/1/23
 */
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/get/{id}")
    public Department getDept(@PathVariable String id) {
        return departmentMapper.getDeptById(Integer.parseInt(id));
    }
}
