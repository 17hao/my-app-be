package xyz.shiqihao.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse<T> {
    private String code;
    private String message;
    private T data;
}
