package xyz.shiqihao.investment.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentAnalyzeResponse {

    /**
     * 投资对象维度（按 l1Type 聚合）
     */
    private List<InvItemAnalysis> invItemAnalysisList;

    /**
     * 投资平台维度（按 opPlatform 聚合）
     */
    private List<InvPlatformAnalysis> invPlatformAnalysisList;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class InvItemAnalysis {
        private String l1Type;
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
    public static final class InvPlatformAnalysis {
        private String opPlatform;
        private BigDecimal amount;

        /**
         * 0~100
         */
        private BigDecimal percent;
    }
}

