package xyz.shiqihao.investment.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 成本分析返回：
 * - itemCostDetails: 投资对象成本（按 l1Type + l2Type 聚合）
 * - platformCostDetails: 投资平台成本（按 opPlatform 聚合）
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentAnalyzeCostResponse {

    /**
     * 投资对象成本
     */
    private List<ItemCostDetail> itemCostDetails;

    /**
     * 投资平台成本
     */
    private List<PlatformCostDetail> platformCostDetails;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class ItemCostDetail {
        private String l1Type;

        private String l2Type;

        private BigDecimal amount;

        /**
         * 0~100
         */
        private BigDecimal percent;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class PlatformCostDetail {
        private String opPlatform;
        private BigDecimal amount;

        /**
         * 0~100
         */
        private BigDecimal percent;
    }
}

