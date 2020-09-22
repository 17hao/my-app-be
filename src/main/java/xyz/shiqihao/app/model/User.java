package xyz.shiqihao.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import xyz.shiqihao.app.dto.UserDto;

import java.time.Instant;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;

    public UserDto translateToDto() {
        return new UserDto(this.getId(), this.getName(), this.getAge(), Instant.now());
    }

}
