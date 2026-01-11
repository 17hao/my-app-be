package xyz.shiqihao.investment.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpItem {

    /**
     * 代号
     */
    private String symbol;

    /**
     * 一级分类
     */
    private String l1Type;

    /**
     * 二级分类
     */
    private String l2Type;

}
