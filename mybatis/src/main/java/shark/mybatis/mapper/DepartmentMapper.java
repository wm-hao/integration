package shark.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import shark.mybatis.pojo.Department;

import java.util.List;

/**
 * @author zhuhh 2019/1/23
 */
@Mapper
public interface DepartmentMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    @Select("select * from department where id =#{depId}")
    Department getDeptById(int id);


    @Select("select * from department where company_id = #{id}")
    List<Department> getDeptByCid(int id);
}
