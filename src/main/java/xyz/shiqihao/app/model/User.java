package xyz.shiqihao.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import xyz.shiqihao.app.dto.UserDto;

import java.time.Instant;

@Data
@AllArgsConstructor
public class User {
    private long id;

    private String name;

    private int age;

    private String city;

    private String phoneNum;

    private String extra;

    public UserDto translateToDto() {
        return new UserDto(
                this.getId(),
                this.getName(),
                this.getAge()
        );
    }

}
