package xyz.shiqihao.app.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import xyz.shiqihao.app.model.User;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    @Select("select * from account where id = #{id}")
    User findById(int id);

    @Select("select * from account;")
    List<User> findAllUsers();

    // @SelectKey(statement = "SELECT id from account order by id desc limit 1;", keyProperty = "id", keyColumn = "id", before = false, resultType = int.class)
    @Insert("INSERT INTO account (name, age) VALUES (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(User u);
}
