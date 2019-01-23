package shark.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shark.mybatis.mapper.CompanyMapper;
import shark.mybatis.pojo.Company;

import java.util.List;

/**
 * @author zhuhh 2019/1/23
 */
@RestController()
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyMapper companyMapper;

    @GetMapping("/get")
    public List<Company> getAll() throws Exception {
        return companyMapper.getAll();
    }

    @GetMapping("/get/{id}")
    public Company getById(@PathVariable String id) {
        return companyMapper.getById(Integer.parseInt(id));
    }
}
