package xyz.shiqihao.investment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.common.exception.BizException;
import xyz.shiqihao.common.util.AssertUtils;
import xyz.shiqihao.investment.repo.dao.InvestmentOperationDAO;
import xyz.shiqihao.investment.repo.model.InvestmentOperationDO;
import xyz.shiqihao.investment.request.CreateInvestmentOperationRequest;
import xyz.shiqihao.investment.response.InvestmentAnalyzeResponse;
import xyz.shiqihao.investment.response.InvestmentOperationResponse;

import static xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.id;
import static xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.isDeleted;
import static xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.opDate;

@Component
@AllArgsConstructor
public class InvestmentOperationService {
    private final InvestmentOperationDAO investmentOperationDAO;

    private static final ObjectMapper OM = new ObjectMapper();

    public long createOperation(CreateInvestmentOperationRequest request) throws JsonProcessingException {
        AssertUtils.isNonNull(request);
        AssertUtils.isNonNull(request.getOpDate());
        AssertUtils.isNonNull(request.getOpPlatform());
        AssertUtils.isNonNull(request.getOpType());
        AssertUtils.isNonNull(request.getOpItem());
        AssertUtils.isNonNull(request.getOpAmount());

        InvestmentOperationDO opeartionDO = new InvestmentOperationDO();
        opeartionDO.setId(IDGenerator.gen());
        opeartionDO.setIsDeleted(false);
        opeartionDO.setCreateTime(LocalDateTime.now());
        opeartionDO.setUpdateTime(LocalDateTime.now());
        opeartionDO.setOpDate(LocalDate.parse(request.getOpDate()));
        opeartionDO.setOpPlatform(request.getOpPlatform());
        opeartionDO.setOpType(request.getOpType());
        opeartionDO.setOpItem(OM.writeValueAsString(request.getOpItem()));
        opeartionDO.setOpAmount(OM.writeValueAsString(request.getOpAmount()));
        investmentOperationDAO.insert(opeartionDO);
        return opeartionDO.getId();
    }

    /**
     * 查询操作列表：过滤已删除，按操作期倒序（再按 id 倒序兜底）。
     */
    public List<InvestmentOperationResponse> getOperationList() throws JsonProcessingException {
        SortSpecification opDateDesc = opDate.descending();
        SortSpecification idDesc = id.descending();

        List<InvestmentOperationDO> records = investmentOperationDAO.select(c ->
                c.where(isDeleted, IsEqualTo.of(false)).orderBy(opDateDesc, idDesc)
        );

        List<InvestmentOperationResponse> res = new ArrayList<>();
        for (InvestmentOperationDO InvestmentOperationDO : records) {
            InvestmentOperationResponse.OpItem opItem = OM
                    .readValue(InvestmentOperationDO.getOpItem(), InvestmentOperationResponse.OpItem.class);

            InvestmentOperationResponse.OpAmount opAmount = OM
                    .readValue(InvestmentOperationDO.getOpAmount(), InvestmentOperationResponse.OpAmount.class);

            InvestmentOperationResponse investmentOperationResponse = new InvestmentOperationResponse();
            investmentOperationResponse.setId(String.valueOf(InvestmentOperationDO.getId()));
            investmentOperationResponse.setOpDate(InvestmentOperationDO.getOpDate().toString());
            investmentOperationResponse.setOpPlatform(InvestmentOperationDO.getOpPlatform());
            investmentOperationResponse.setOpType(InvestmentOperationDO.getOpType());
            investmentOperationResponse.setOpItem(opItem);
            investmentOperationResponse.setOpAmount(opAmount);
            res.add(investmentOperationResponse);
        }

        return res;
    }

    /**
     * /investment/analyze
     * <p>
     * 查询所有未删除流水，并做两类聚合：
     * 1) 按 OpItem.l1Type 聚合
     * 2) 按 opPlatform 聚合
     * <p>
     * amount 口径：sum(opAmount.equivalentCny)，SELL 按负数计入。
     * percent：0~100。
     */
    public InvestmentAnalyzeResponse analyze() throws JsonProcessingException {
        List<InvestmentOperationDO> records = investmentOperationDAO.select(c ->
                c.where(isDeleted, IsEqualTo.of(false))
        );

        Map<String, BigDecimal> l1Type2Amount = new HashMap<>();
        Map<String, BigDecimal> platform2Amount = new HashMap<>();

        for (InvestmentOperationDO r : records) {
            InvestmentOperationResponse.OpItem opItem = OM
                    .readValue(r.getOpItem(), InvestmentOperationResponse.OpItem.class);
            InvestmentOperationResponse.OpAmount opAmount = OM
                    .readValue(r.getOpAmount(), InvestmentOperationResponse.OpAmount.class);

            BigDecimal amount = parseBigDecimal(opAmount.getEquivalentCny());
            if (amount == null) {
                continue;
            }

            // SELL 按负数
            if ("sell".equalsIgnoreCase(r.getOpType())) {
                amount = amount.negate();
            }

            String l1Type = opItem == null ? null : opItem.getL1Type();
            if (l1Type != null && !l1Type.isBlank()) {
                l1Type2Amount.merge(l1Type, amount, BigDecimal::add);
            }

            String platform = r.getOpPlatform();
            if (platform != null && !platform.isBlank()) {
                platform2Amount.merge(platform, amount, BigDecimal::add);
            }
        }

        List<InvestmentAnalyzeResponse.InvItemAnalysis> itemAnalyzes = buildItemAnalyzes(l1Type2Amount);
        List<InvestmentAnalyzeResponse.InvPlatformAnalysis> platformAnalyzes = buildPlatformAnalyzes(platform2Amount);

        return new InvestmentAnalyzeResponse(itemAnalyzes, platformAnalyzes);
    }

    private List<InvestmentAnalyzeResponse.InvItemAnalysis> buildItemAnalyzes(Map<String, BigDecimal> l1Type2Amount) {
        BigDecimal total = l1Type2Amount.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<InvestmentAnalyzeResponse.InvItemAnalysis> res = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> e : l1Type2Amount.entrySet()) {
            BigDecimal amount = defaultBigDecimal(e.getValue());
            BigDecimal percent = calcPercent(amount, total);
            res.add(new InvestmentAnalyzeResponse.InvItemAnalysis(e.getKey(), amount, percent));
        }

        // amount 倒序
        res.sort(Comparator.comparing(InvestmentAnalyzeResponse.InvItemAnalysis::getAmount).reversed());
        return res;
    }

    private List<InvestmentAnalyzeResponse.InvPlatformAnalysis> buildPlatformAnalyzes(Map<String, BigDecimal> platform2Amount) {
        BigDecimal total = platform2Amount.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<InvestmentAnalyzeResponse.InvPlatformAnalysis> res = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> e : platform2Amount.entrySet()) {
            BigDecimal amount = defaultBigDecimal(e.getValue());
            BigDecimal percent = calcPercent(amount, total);
            res.add(new InvestmentAnalyzeResponse.InvPlatformAnalysis(e.getKey(), amount, percent));
        }
        res.sort(Comparator.comparing(InvestmentAnalyzeResponse.InvPlatformAnalysis::getAmount).reversed());
        return res;
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

    private BigDecimal parseBigDecimal(String v) {
        if (v == null || v.isBlank()) {
            return null;
        }
        try {
            return new BigDecimal(v);
        } catch (Exception ignore) {
            return null;
        }
    }

    /**
     * 软删除一条操作流水。
     */
    public void deleteOperation(long id) {
        InvestmentOperationDO existing = investmentOperationDAO
                .selectByPrimaryKey(id)
                .orElseThrow(() -> new BizException("NOT_FOUND", "operation not found"));
        if (Boolean.TRUE.equals(existing.getIsDeleted())) {
            throw new BizException("NOT_FOUND", "operation not found");
        }

        int updated = investmentOperationDAO.update(c ->
                c.set(isDeleted).equalTo(true)
                        .set(xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.updateTime)
                        .equalTo(LocalDateTime.now())
                        .where(xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.id,
                                IsEqualTo.of(id))
                        .and(isDeleted, IsEqualTo.of(false))
        );
        if (updated == 0) {
            // 并发下被删/不存在
            throw new BizException("NOT_FOUND", "operation not found");
        }
    }
}
