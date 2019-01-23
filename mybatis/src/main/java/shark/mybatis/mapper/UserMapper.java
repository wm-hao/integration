package shark.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import shark.mybatis.pojo.User;

import java.util.List;

/**
 * @author zhuhh 2019/1/22
 */
@Mapper
public interface UserMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "department", column = "depId", one = @One(select = "shark.mybatis.mapper.DepartmentMapper.getDeptById"))
    })
    @Select("select * from users")
    List<User> getUser() throws Exception;

    @Delete("delete from users where id=#{id}")
    void deleteUser(int id) throws Exception;

    @Insert("insert into users(name,age,depId) values(#{username},#{age},#{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(User user) throws Exception;

    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    void updateT(User user);

}
