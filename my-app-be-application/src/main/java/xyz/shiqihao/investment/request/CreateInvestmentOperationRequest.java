package xyz.shiqihao.investment.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateInvestmentOperationRequest {

    /**
     * 操作对象
     */
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

    /**
     * 操作金额
     */
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

    /**
     * 操作期（日期）
     */
    private String opDate;

    /**
     * 操作平台
     */
    private String opPlatform;

    /**
     * 操作类型
     */
    private String opType;

    /**
     * 操作对象
     */
    private OpItem opItem;

    /**
     * 操作金额（字符串存储，保持与表结构一致）
     */
    private OpAmount opAmount;
}

