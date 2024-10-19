package xyz.shiqihao.app.form;

import lombok.Data;
import xyz.shiqihao.app.model.User;
import xyz.shiqihao.common.IDGenerator;

@Data
public class UserForm {
    String name;

    int age;

    String city;

    String phoneNum;

    public User buildUser() {
        return new User(IDGenerator.gen(), this.name, this.age, this.city, this.phoneNum, false);
    }
}
