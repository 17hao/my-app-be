package xyz.shiqihao.account.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerifyAccountRequest {
    private String id;

    private String name;

    private String password;
}
