package xyz.shiqihao.investment.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageResponse<T> {

    private List<T> list;

    private int total;

}
