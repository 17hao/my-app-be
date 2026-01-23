package xyz.shiqihao.common;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Test {

    @Setter
    @Getter
    @ToString
    static class Foo {
        BigDecimal num;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String jsonStr = "{\n" +
                "    \"num\": 1\n" +
                "}";


        Foo f = new ObjectMapper().readValue(jsonStr, Foo.class);
        System.out.println(f);
    }
}
