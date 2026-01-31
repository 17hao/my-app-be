package xyz.shiqihao.investment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.common.exception.BizException;
import xyz.shiqihao.common.util.AssertUtils;
import xyz.shiqihao.investment.model.InvestmentOperation;
import xyz.shiqihao.investment.model.InvestmentOperationDTO;
import xyz.shiqihao.investment.repository.dao.InvestmentOperationDAO;
import xyz.shiqihao.investment.repository.model.InvestmentOperationDO;
import xyz.shiqihao.investment.request.CreateInvestmentOperationRequest;
import xyz.shiqihao.investment.response.PageQueryInvestmentOperationResponse;
import xyz.shiqihao.investment.util.ConvertObjectUtils;

import static xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.id;
import static xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.isDeleted;
import static xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.opDate;

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

        InvestmentOperationDO operationDO = new InvestmentOperationDO();
        operationDO.setId(IDGenerator.gen());
        operationDO.setIsDeleted(false);
        operationDO.setCreateTime(LocalDateTime.now());
        operationDO.setUpdateTime(LocalDateTime.now());
        operationDO.setOpDate(LocalDate.parse(request.getOpDate()));
        operationDO.setOpPlatform(request.getOpPlatform());
        operationDO.setOpType(request.getOpType());
        operationDO.setOpItem(OM.writeValueAsString(request.getOpItem()));
        operationDO.setOpAmount(OM.writeValueAsString(request.getOpAmount()));
        investmentOperationDAO.insert(operationDO);
        return operationDO.getId();
    }

    /**
     * 分页查询操作列表（同时返回未删除记录总数）。
     * <p>
     * 当 pageNum/pageSize 为空时：list 返回全量；total 返回未删除总数。
     */
    public PageQueryInvestmentOperationResponse getOperationListPage(int pageNum, int pageSize) throws JsonProcessingException {
        long total = investmentOperationDAO.count(c -> c.where(isDeleted, IsEqualTo.of(false)));

        long offset = ((long) pageNum - 1L) * (long) pageSize;
        if (offset > Integer.MAX_VALUE) {
            // MyBatis dynamic sql offset/limit is int
            throw new BizException("INVALID_ARGS", "pageNum/pageSize too large");
        }

        List<InvestmentOperationDO> dataObjList = investmentOperationDAO.select(c ->
                c.where(isDeleted, IsEqualTo.of(false))
                        .orderBy(opDate.descending(), id.descending())
                        .limit(pageSize)
                        .offset((int) offset)
        );

        List<InvestmentOperationDTO> dtoList = new ArrayList<>();
        for (InvestmentOperationDO dataObj : dataObjList) {
            InvestmentOperation model = ConvertObjectUtils.convertToVO(dataObj);
            dtoList.add(ConvertObjectUtils.convertToDTO(model));
        }

        PageQueryInvestmentOperationResponse res = new PageQueryInvestmentOperationResponse();
        res.setList(dtoList);
        // PageResponse.total 为 int，避免溢出
        res.setTotal(total > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) total);
        return res;
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
                        .set(xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.updateTime)
                        .equalTo(LocalDateTime.now())
                        .where(xyz.shiqihao.investment.repository.dao.InvestmentOperationDODynamicSqlSupport.id,
                                IsEqualTo.of(id))
                        .and(isDeleted, IsEqualTo.of(false))
        );
        if (updated == 0) {
            // 并发下被删/不存在
            throw new BizException("NOT_FOUND", "operation not found");
        }
    }
}
