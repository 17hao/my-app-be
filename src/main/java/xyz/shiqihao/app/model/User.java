package xyz.shiqihao.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import xyz.shiqihao.app.dto.UserDto;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private final long id;

    private String name;

    private int age;

    private String city;

    private String phoneNum;

    private String extra;

    private boolean deleted;

    public UserDto translateToDto() {
        return new UserDto(
                this.getId(),
                this.getName(),
                this.getAge()
        );
    }

}
