package xyz.shiqihao.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {
    private final String errCode;

    private final String errMessage;
}
