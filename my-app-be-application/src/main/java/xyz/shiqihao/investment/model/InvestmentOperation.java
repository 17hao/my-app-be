package xyz.shiqihao.investment.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentOperation {

    @Setter
    @Getter
    public static class OpAmount {

        /**
         * 数值
         */
        private BigDecimal number;


        /**
         * 币种
         */
        private Currency currency;

        /**
         * 等额人民币
         */
        private BigDecimal equivalentCny;

    }

    @Setter
    @Getter
    public static class OpItem {

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

    @Getter
    @AllArgsConstructor
    public enum OpPlatform {
        CMB("招商银行"),

        YINHE("银河证券"),

        PINGAN("平安证券"),

        USMART_SG("盈立证券sg"),

        ZA_BANK("众安银行"),

        IBKR("盈透证券"),

        HSBC_BANK("汇丰银行"),

        SCHWAB("嘉信理财"),
        ;


        private final String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum OpType {
        BUY("买入"),

        SELL("卖出"),
        ;


        private final String desc;
    }

    private String id;

    /**
     * 操作期（日期）
     */
    private LocalDate opDate;

    /**
     * 操作平台
     */
    private OpPlatform opPlatform;

    /**
     * 操作类型
     */
    private OpType opType;

    /**
     * 操作对象
     */
    private OpItem opItem;

    /**
     * 操作金额（字符串存储，保持与表结构一致）
     */
    private OpAmount opAmount;

}
