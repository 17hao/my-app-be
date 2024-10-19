package xyz.shiqihao.common;

import lombok.Data;

@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;

    public Response() {
        this.code = "0";
        this.message = "";
    }
}
