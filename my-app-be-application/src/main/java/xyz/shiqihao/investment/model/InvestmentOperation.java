package xyz.shiqihao.investment.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentOperation {

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
