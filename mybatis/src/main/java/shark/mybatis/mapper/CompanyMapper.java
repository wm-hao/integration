package shark.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import shark.mybatis.pojo.Company;

import java.util.List;

/**
 * @author zhuhh 2019/1/23
 */
@Mapper
public interface CompanyMapper {

    @Select("select * from company")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "companyName", column = "name"),
            @Result(property = "departments", column = "id", many = @Many(select = "shark.mybatis.mapper.DepartmentMapper.getDeptByCid"))
    })
    List<Company> getAll() throws Exception;

    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "companyName", column = "name"),
            @Result(property = "departments", column = "id", many = @Many(select = "shark.mybatis.mapper.DepartmentMapper.getDeptByCid"))
    })
    @Select("select * from company where id = #{id}")
    Company getById(int id);
}
