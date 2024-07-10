package xyz.shiqihao.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import xyz.shiqihao.app.model.User;

@Component
@Mapper
public interface UserDao {
    @Select("select * from users where id = #{id} and is_deleted = false;")
    @Results(id = "userMap", value = {
            @Result(property = "deleted", column = "is_deleted")
    })
    User findById(int id);

    @Select("select * from users where is_deleted = false;")
    @ResultMap("userMap")
    List<User> findAllUsers();

    @Select("select * from users where is_deleted = true;")
    @ResultMap("userMapV2")
    List<User> findAllDeletedUsers();

    @Insert("INSERT INTO users (id, name, age, city, phone_num, extra) VALUES (#{id}, #{name}, #{age}, #{city}, #{phoneNum}, #{extra})")
    @Options(keyProperty = "id", keyColumn = "id")
    void insert(User u);
}
