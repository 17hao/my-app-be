package xyz.shiqihao.investment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.investment.model.InvestmentOperation;
import xyz.shiqihao.investment.repository.dao.InvestmentOperationDAO;
import xyz.shiqihao.investment.repository.model.InvestmentOperationDO;
import xyz.shiqihao.investment.response.InvestmentAnalyzeCostResponse;
import xyz.shiqihao.investment.util.ConvertObjectUtils;

import static xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.isDeleted;

@Component
@AllArgsConstructor
public class InvestmentAnalysisService {

    private final InvestmentOperationDAO investmentOperationDAO;

    /**
     * /investment/analyzeCost
     * <p>
     * 查询所有未删除流水，并做两类聚合：
     * 1) 按 (OpItem.l1Type, OpItem.l2Type) 聚合
     * 2) 按 opPlatform 聚合
     * <p>
     * amount 口径：sum(opAmount.equivalentCny)，SELL 按负数计入。
     * percent：0~100。
     */
    public InvestmentAnalyzeCostResponse analyzeCost() throws JsonProcessingException {
        List<InvestmentOperationDO> dataObjList = investmentOperationDAO.select(c ->
                c.where(isDeleted, IsEqualTo.of(false))
        );

        List<InvestmentOperation> modelList = new ArrayList<>();
        for (InvestmentOperationDO dataObj : dataObjList) {
            modelList.add(ConvertObjectUtils.convertToVO(dataObj));
        }

        Map<ItemKey, BigDecimal> itemKeyToAmount = new HashMap<>();
        Map<String, BigDecimal> platformToAmount = new HashMap<>();

        for (InvestmentOperation model : modelList) {
            InvestmentOperation.OpAmount opAmount = model.getOpAmount();
            InvestmentOperation.OpItem opItem = model.getOpItem();

            BigDecimal amount = opAmount.getEquivalentCny();
            if (amount == null) {
                continue;
            }

            // SELL 按负数
            if (InvestmentOperation.OpType.SELL.equals(model.getOpType())) {
                amount = opAmount.getEquivalentCny().negate();
            }

            String l1Type = opItem == null ? null : opItem.getL1Type();
            String l2Type = opItem == null ? null : opItem.getL2Type();
            if (l1Type != null && !l1Type.isBlank()) {
                itemKeyToAmount.merge(new ItemKey(l1Type, defaultString(l2Type)), amount, BigDecimal::add);
            }

            String platform = model.getOpPlatform().name().toLowerCase();
            platformToAmount.merge(platform, amount, BigDecimal::add);
        }

        List<InvestmentAnalyzeCostResponse.ItemCostDetail> itemCostDetails = buildItemCostDetails(itemKeyToAmount);
        List<InvestmentAnalyzeCostResponse.PlatformCostDetail> platformCostDetails =
                buildPlatformCostDetails(platformToAmount);

        return new InvestmentAnalyzeCostResponse(itemCostDetails, platformCostDetails);
    }

    private List<InvestmentAnalyzeCostResponse.ItemCostDetail> buildItemCostDetails(Map<ItemKey, BigDecimal> itemKey2Amount) {
        BigDecimal total = itemKey2Amount.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<InvestmentAnalyzeCostResponse.ItemCostDetail> res = new ArrayList<>();
        for (Map.Entry<ItemKey, BigDecimal> e : itemKey2Amount.entrySet()) {
            BigDecimal amount = defaultBigDecimal(e.getValue());
            BigDecimal percent = calcPercent(amount, total);
            res.add(new InvestmentAnalyzeCostResponse.ItemCostDetail(
                    e.getKey().l1Type,
                    e.getKey().l2Type,
                    amount,
                    percent
            ));
        }
        res.sort(Comparator.comparing(InvestmentAnalyzeCostResponse.ItemCostDetail::getAmount).reversed());
        return res;
    }

    private List<InvestmentAnalyzeCostResponse.PlatformCostDetail> buildPlatformCostDetails(Map<String, BigDecimal> platform2Amount) {
        BigDecimal total = platform2Amount.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<InvestmentAnalyzeCostResponse.PlatformCostDetail> res = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> e : platform2Amount.entrySet()) {
            BigDecimal amount = defaultBigDecimal(e.getValue());
            BigDecimal percent = calcPercent(amount, total);
            res.add(new InvestmentAnalyzeCostResponse.PlatformCostDetail(e.getKey(), amount, percent));
        }
        res.sort(Comparator.comparing(InvestmentAnalyzeCostResponse.PlatformCostDetail::getAmount).reversed());
        return res;
    }

    private String defaultString(String x) {
        return x == null ? "" : x;
    }

    private static final class ItemKey {
        private final String l1Type;
        private final String l2Type;

        private ItemKey(String l1Type, String l2Type) {
            this.l1Type = l1Type;
            this.l2Type = l2Type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ItemKey)) {
                return false;
            }
            ItemKey that = (ItemKey) o;
            return l1Type.equals(that.l1Type) && l2Type.equals(that.l2Type);
        }

        @Override
        public int hashCode() {
            int result = l1Type.hashCode();
            result = 31 * result + l2Type.hashCode();
            return result;
        }
    }

    private BigDecimal calcPercent(BigDecimal amount, BigDecimal total) {
        if (total == null || total.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        // percent = amount / total * 100
        return amount
                .multiply(new BigDecimal("100"))
                .divide(total, 4, RoundingMode.HALF_UP);
    }

    private BigDecimal defaultBigDecimal(BigDecimal x) {
        return x == null ? BigDecimal.ZERO : x;
    }

}
