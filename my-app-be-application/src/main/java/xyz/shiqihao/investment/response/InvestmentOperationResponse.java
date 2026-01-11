package xyz.shiqihao.investment.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentOperationResponse {


    @Setter
    @Getter
    public static final class OpItem {
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

    @Setter
    @Getter
    public static final class OpAmount {
        /**
         * 数值
         */
        private String number;

        /**
         * 币种
         */
        private String currency;

        /**
         * 等额人民币
         */
        private String equivalentCny;
    }

    private String id;

    private String opDate;

    private String opPlatform;

    private String opType;

    private OpItem opItem;

    private OpAmount opAmount;

}

