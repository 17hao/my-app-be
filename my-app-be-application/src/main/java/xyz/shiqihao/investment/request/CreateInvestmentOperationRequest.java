package xyz.shiqihao.investment.request;

import lombok.Getter;
import lombok.Setter;
import xyz.shiqihao.investment.model.InvestmentOperation;

@Setter
@Getter
public class CreateInvestmentOperationRequest {

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
    private InvestmentOperation.OpItem opItem;

    /**
     * 操作金额（字符串存储，保持与表结构一致）
     */
    private InvestmentOperation.OpAmount opAmount;

}

