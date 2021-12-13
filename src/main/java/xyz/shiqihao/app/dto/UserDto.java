package xyz.shiqihao.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    int id;
    String name;
    int age;
    String city;
    String phoneNum;
    String extra;
}
