package xyz.shiqihao.app.form;

import lombok.Data;
import xyz.shiqihao.app.model.User;

@Data
public class UserForm {
    String name;
    int age;

    public User buildUser() {
        return new User(-1, this.name, this.age);
    }
}
