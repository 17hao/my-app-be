package xyz.shiqihao.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountException extends RuntimeException {
    private String errMessage;
}
