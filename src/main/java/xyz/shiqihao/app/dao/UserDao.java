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
    @Select("select * from users where id = #{id}")
    User findById(int id);

    @Select("select * from users;")
    List<User> findAllUsers();

    @Insert("INSERT INTO users (id, name, age, city, phone_num, extra) VALUES (#{id}, #{name}, #{age}, #{city}, #{phoneNum}, #{extra})")
    @Options(keyProperty = "id", keyColumn = "id")
    void insert(User u);
}
