package xyz.shiqihao.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.shiqihao.app.dao.UserDao;
import xyz.shiqihao.app.dto.UserDto;
import xyz.shiqihao.app.form.UserForm;
import xyz.shiqihao.app.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDto findById(int id) {
        return userDao.findById(id).translateToDto();
    }

    public List<UserDto> findAllUsers() {
        return userDao.findAllUsers().stream().map(User::translateToDto).collect(Collectors.toList());
    }

    public UserDto insert(UserForm form) {
        User user = form.buildUser();
        userDao.insert(user);
        return user.translateToDto();
    }
}
