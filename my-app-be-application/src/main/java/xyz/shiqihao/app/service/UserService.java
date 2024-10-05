package xyz.shiqihao.app.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.shiqihao.app.dao.UserDao;
import xyz.shiqihao.app.dto.UserDto;
import xyz.shiqihao.app.form.UserForm;
import xyz.shiqihao.app.model.User;

@Component
@AllArgsConstructor
public class UserService {
    private UserDao userDao;

    public UserDto findById(long id) {
        User user = userDao.findById(id);
        if (user == null) {
            return null;
        }
        return user.translateToDto();
    }

    public List<UserDto> findAllUsers() {
        return userDao.findAllUsers().stream().map(User::translateToDto).collect(Collectors.toList());
    }

    public List<UserDto> findAllDeletedUsers() {
        return userDao.findAllDeletedUsers().stream().map(User::translateToDto).collect(Collectors.toList());
    }

    private boolean checkUserForm(UserForm form) {
        return true;
    }

    public UserDto insert(UserForm form) {
        if (!checkUserForm(form)) {
            return new UserDto();
        }
        User user = form.buildUser();
        userDao.insert(user);
        return user.translateToDto();
    }
}
