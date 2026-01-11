package xyz.shiqihao.investment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpType {
    BUY("buy", "买入"),

    SELL("sell", "卖出"),
    ;

    private final String code;

    private final String name;
}
