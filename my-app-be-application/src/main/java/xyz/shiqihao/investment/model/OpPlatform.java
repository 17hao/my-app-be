package xyz.shiqihao.investment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpPlatform {
    CMB("cmb", "招商银行"),

    CHINA_STOCK("china_stock", "银河证券"),

    PINGAN("pingan", "平安证券"),

    USMART_SG("usmart_sg", "盈立证券sg"),

    ZA_BANK("za", "众安银行"),

    IBKR("ibkr", "盈透证券"),

    HSBC_BANK("hsbc", "汇丰银行"),

    SCHWAB("schwab", "嘉信理财"),
    ;

    private final String code;

    private final String name;
}
